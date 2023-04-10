package com.wifi;

import com.db.DbConnection;
import com.db.JdbcUtill;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.sql.Connection;

public class SeoulWifiData {

    static int totalcount = 2;
    public static String SeoulWifiDataCommit(int startIdx, int endIdx) throws IOException {

        String url = "http://openapi.seoul.go.kr:8088";
        String serviceKey = "707472587a776c7438354e78565741";
        String fileType = "json";
        String serviceName = "TbPublicWifiInfo";

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url + "/" + serviceKey + "/" + fileType + "/" + serviceName + "/" + startIdx + "/" + endIdx)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            String responseBody = response.body().string();
            System.out.println(responseBody);

            return responseBody;



        }
    }

    public static void SeoulDbCommit() throws IOException {
        Gson gson = new Gson();
        int startIdx = 1;
        int endIdx = 1000;



        Connection con = JdbcUtill.getConnection();
        DbConnection.DbDeleteTable(con);


        while (true) {

            String s = SeoulWifiDataCommit(startIdx, endIdx);
            Root root = gson.fromJson(s, Root.class);
            if(!root.isSuccess()){
                break;
            }


            for (int i = 0; i < root.tbPublicWifiInfo.getRow().size(); i++) {
                totalcount = root.tbPublicWifiInfo.getList_total_count();


                DbConnection.Dbinserto(con,
                        root.tbPublicWifiInfo.getRow().get(i).getX_SWIFI_MGR_NO(),
                        root.tbPublicWifiInfo.getRow().get(i).getX_SWIFI_WRDOFC(),
                        root.tbPublicWifiInfo.getRow().get(i).getX_SWIFI_MAIN_NM(),
                        root.tbPublicWifiInfo.getRow().get(i).getX_SWIFI_ADRES1(),
                        root.tbPublicWifiInfo.getRow().get(i).getX_SWIFI_ADRES2(),
                        root.tbPublicWifiInfo.getRow().get(i).getX_SWIFI_INSTL_FLOOR(),
                        root.tbPublicWifiInfo.getRow().get(i).getX_SWIFI_INSTL_TY(),
                        root.tbPublicWifiInfo.getRow().get(i).getX_SWIFI_INSTL_MBY(),
                        root.tbPublicWifiInfo.getRow().get(i).getX_SWIFI_SVC_SE(),
                        root.tbPublicWifiInfo.getRow().get(i).getX_SWIFI_CMCWR(),
                        root.tbPublicWifiInfo.getRow().get(i).getX_SWIFI_CNSTC_YEAR(),
                        root.tbPublicWifiInfo.getRow().get(i).getX_SWIFI_INOUT_DOOR(),
                        root.tbPublicWifiInfo.getRow().get(i).getX_SWIFI_REMARS3(),
                        root.tbPublicWifiInfo.getRow().get(i).getLAT(),
                        root.tbPublicWifiInfo.getRow().get(i).getLNT(),
                        root.tbPublicWifiInfo.getRow().get(i).getWORK_DTTM()
                );
            }
            startIdx += 1000;
            endIdx = startIdx + 999;


        }


        JdbcUtill.close(con);



    }

}

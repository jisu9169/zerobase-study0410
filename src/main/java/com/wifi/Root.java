package com.wifi;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Root {

    @SerializedName("TbPublicWifiInfo")
    public TbPublicWifiInfo tbPublicWifiInfo;

    public boolean isSuccess(){

        return tbPublicWifiInfo!=null;
    }

    @Data
    @AllArgsConstructor
    public static class TbPublicWifiInfo {
        private int list_total_count;
        private Result RESULT;
        private List<Row> row;





        @Data
        @AllArgsConstructor
        public static class Result {
            private String CODE;
            private String MESSAGE;
        }


        @Data
        @AllArgsConstructor
        public static class Row {

            private String X_SWIFI_MGR_NO;
            private String X_SWIFI_WRDOFC;
            private String X_SWIFI_MAIN_NM;
            private String X_SWIFI_ADRES1;
            private String X_SWIFI_ADRES2;
            private String X_SWIFI_INSTL_FLOOR;
            private String X_SWIFI_INSTL_TY;
            private String X_SWIFI_INSTL_MBY;
            private String X_SWIFI_SVC_SE;
            private String X_SWIFI_CMCWR;
            private String X_SWIFI_CNSTC_YEAR;
            private String X_SWIFI_INOUT_DOOR;
            private String X_SWIFI_REMARS3;
            private String LAT;
            private String LNT;
            private String WORK_DTTM;

        }
    }

}

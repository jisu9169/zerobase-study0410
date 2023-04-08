package com.wifi;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


        SeoulWifiData seoulWifiData = new SeoulWifiData();


        try {
            seoulWifiData.SeoulDbCommit();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.wifi;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookMarkDataValue {

    @Data
    @AllArgsConstructor
    public static class row {
        private int id;
        private String bookmark_name;
        private String wifi_name;
        private int order_num;
        private String registration_date;
        private String modification_date;
    }
}

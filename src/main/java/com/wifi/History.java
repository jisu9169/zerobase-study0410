package com.wifi;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class History {
    @Data
    @AllArgsConstructor
    public static class row{
        private int id;
        private Double LAT;
        private Double LNT;
        private String search_date;
    }
}

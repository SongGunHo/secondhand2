package org.koreait.restaurant.controllers;

import lombok.Data;
import org.koreait.global.search.CommonSeacrch;

@Data
public class RestaurantSearch extends CommonSeacrch {
    private double lat;
    private double lon;
    private int cnt;
}

package org.koreait.trend.enties;

import lombok.Data;

import java.util.Map;

@Data
public class NewTrend {
    private String image;
    private Map<String, Integer> keywords;

}

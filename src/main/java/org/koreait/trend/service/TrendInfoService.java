package org.koreait.trend.service;

import lombok.RequiredArgsConstructor;
import org.koreait.global.search.CommonSearch;
import org.koreait.trend.enties.Trend;
import org.koreait.trend.except.TrendNotFoundException;
import org.koreait.trend.repository.TrendRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Lazy
@Service
@RequiredArgsConstructor
public class TrendInfoService {

    private final TrendRepository repository;



    /**
     *
     *
     * 최근 트랜드 1게 조회
     * @param category
     * @return
     */
    public Trend getLatest(String category){

        //Trend t  = new Trend();
        Trend t = repository.getLatest(category).orElseThrow(TrendNotFoundException::new);

        return null;
    }

    /**
     *
     * 특정 날자의 트렌트 데이터 1개
     * @param date
     * @return
     */

    public Trend get(LocalDate date, String category){
        return null;
    }

    /**
     * 특정 날짜 범위와 트렌드 조회
     * @return
     */

    public List<Trend> ageList(String category , CommonSearch search){
        return null;
    }


}

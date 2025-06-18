package org.koreait.trend.repository;

import org.koreait.trend.enties.Trend;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface TrendRepository extends ListCrudRepository<Trend, Long> {
    @Query("SELECT * FROM TREND WHERE category=:category ORDER BY createdAt DESC LIMIT 1")
    Optional<Trend> getLatest(String category);
}

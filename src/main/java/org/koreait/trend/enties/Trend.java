package org.koreait.trend.enties;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Data;
import org.koreait.global.entities.BaseEntity;
import org.springframework.data.annotation.Id;
//import org.springframework.data.relational.core.mapping.Column;
//import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name="TREND")
public class Trend extends BaseEntity {

    @Id
    private long id;
    private String category;

    @Column(name = "worducloud")
    private String wordcloud;
    private String keywords;














}

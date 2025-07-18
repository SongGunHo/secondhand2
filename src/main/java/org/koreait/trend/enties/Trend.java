package org.koreait.trend.enties;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Data;
import org.koreait.global.entities.BaseEntity;
import org.springframework.data.annotation.Id;


@Data
//@Table("trend")
public class Trend extends BaseEntity {

    @Id
    private long id;
    private String category;
    @Column("wordcloud")
    private String wordcloud;
    private String keywords;
}

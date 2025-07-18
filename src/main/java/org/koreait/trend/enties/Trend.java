package org.koreait.trend.enties;

import jakarta.persistence.Column;
import lombok.Data;
import org.koreait.global.entities.BaseEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("TREND")
public class Trend extends BaseEntity {

    @Id
    private long id;
    private String category;
    @Column("wordcloud")
    private String wordcloud;
    private String keywords;
}

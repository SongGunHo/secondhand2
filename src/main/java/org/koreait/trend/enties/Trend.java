package org.koreait.trend.enties;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
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

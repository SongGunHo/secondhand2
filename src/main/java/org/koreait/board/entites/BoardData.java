package org.koreait.board.entites;

import jakarta.persistence.*;
import lombok.Data;
import org.koreait.global.entities.BaseEntity;

@Data
@Entity
public class BoardData extends BaseEntity {

    @Id
    @GeneratedValue
    private Long seq;


    @JoinColumn(name = "bid")
    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;












}

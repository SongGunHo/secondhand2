package org.koreait.board.repository;

import org.koreait.board.entites.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BoardRepository extends JpaRepository<Board, String>, QuerydslPredicateExecutor<Board> {
    boolean existsBid(String bid);
}

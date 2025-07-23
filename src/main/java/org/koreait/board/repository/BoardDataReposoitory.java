package org.koreait.board.repository;

import org.koreait.board.entites.BoardData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BoardDataReposoitory extends JpaRepository<BoardData, String>, QuerydslPredicateExecutor<BoardData> {
}

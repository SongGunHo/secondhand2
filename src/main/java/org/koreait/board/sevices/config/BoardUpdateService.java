package org.koreait.board.sevices.config;

import lombok.RequiredArgsConstructor;
import org.koreait.board.repository.BoardRepository;
import org.koreait.global.configs.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Lazy
@Service
@RequiredArgsConstructor
public class BoardUpdateService {

    private final ModelMapper mapper;
    private final BoardRepository repository;

    public void process(){

    }
}

package org.koreait.board.controller;

import lombok.RequiredArgsConstructor;
import org.koreait.admin.board.controllers.BoardSearch;
import org.koreait.global.annotations.ApplyCommonController;
import org.koreait.global.libs.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
@ApplyCommonController
public class BoardController {

    private final Utils utils;
    // 게시글 목록
    @GetMapping("/list{bid}")
    public String list(@PathVariable("bid") String bid , @ModelAttribute BoardSearch search, Model model){
        return utils.tpl("board/list");
    }
    // 게시글 작성
    @GetMapping("/write/{bid}")
    public String write(@PathVariable("bid")String bid, Model model){
        return utils.tpl("board/writer");
    }
    // 게시글 수정
    @GetMapping("/update/{bid}")
    public String update(@PathVariable("bid")String bid, Model model){
        return utils.tpl("/board/update");
    }
    // 게시글 보기
    @GetMapping("/view/{bid}")
    public String view(@PathVariable("bid") String bid, Model model){
        return utils.tpl("board/view");
    }
    // 게시글 삭제
    @GetMapping("/delete/{bid}")
    public String delete(@PathVariable("seq") String seq, Model model){
        return "redirect:/board/list";
    }
}


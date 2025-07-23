package org.koreait.admin.board.controllers;

import ch.qos.logback.core.model.Model;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.koreait.admin.board.validator.BoardConfigValidator;
import org.koreait.admin.global.controllers.CommonController;
import org.koreait.board.sevices.config.BoardConfigInfoService;
import org.koreait.board.sevices.config.BoardUpdateService;
import org.koreait.global.annotations.ApplyCommonController;
import org.koreait.member.constants.Authority;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@ApplyCommonController
@RequestMapping("/admin/board")
public class BoardController extends CommonController {
    private BoardConfigValidator configValidator;
    private BoardUpdateService service;
    private final BoardConfigInfoService infoService;




    @Override
    @ModelAttribute("MainCode")
    public String mainCode() {
        return "board";
    }


    @GetMapping({"", "list"})
    public String list( Model model){
        coomProcess("list", model);


        return "admin/board/list";
    }

    @GetMapping("/register")
    public String register(@ModelAttribute RequestBoard form, Model model){
        coomProcess("register", model);
        form.setSkin("defult");
        form.setListAuthority(Authority.All);
        form.setViewAuthority(Authority.All);
        form.setWriteAuthority(Authority.All);
        form.setCommentAuthority(Authority.All);
        form.setRowsForPage(20);
        form.setPageCount(10);
        return "admin/board/register";
    }
    @GetMapping("/updatebid")
    public String update(@PathVariable("bid") String bid, org.springframework.ui.Model model){
//        coomProcess("update", model);
////        RequestBoard item = infoService.getForm(bid);
////        model.addAttribute()
        return "admin/board/update";
    }

    @PostMapping("/save")
    public String save(@Valid RequestBoard form, Errors errors, Model model){
        String mode = form.getMode();
        mode = StringUtils.hasText(mode) ? mode : "register";
        coomProcess(mode, model);

        configValidator.validate(form, errors);

        if (errors.hasErrors()) {
            return "admin/board/" + mode;
        }

//        service.process(form);

        return "redircet:/admin/board";

    }


    /**
     * 컨트롤러 요청 처리 메서드의 공통 처리 부분
     *
     * @param code
     */
    private void coomProcess(String code, Model model){
        String pageTitle = "";
        code = StringUtils.hasText(code ) ? code :"list";
        if(code.equals("register")){
            pageTitle = "게시판 등록";
        }else {
            pageTitle ="게시판 목록";
        }



    }
}

package com.study.board.controller;

import com.study.board.Service.BoardService;
import com.study.board.entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write") //어떤 url로 접근할지 지정해주는 localhost:8080/board/write
    public String boardWriteForm(){

        return "boardwrite"; //어떤 html파일로 보내줄지
    }
    @PostMapping("/board/writepro") //form tag의 action과 일치해야한다
    public String boardWritePro(Board board){ //entity형식 그대로 받아올 수 있다

        boardService.write(board);

        return "";
    }
}

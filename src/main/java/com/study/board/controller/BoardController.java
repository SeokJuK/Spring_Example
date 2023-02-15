package com.study.board.controller;

import com.study.board.Service.BoardService;
import com.study.board.entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String boardWritePro(Board board, Model model){ //entity형식 그대로 받아올 수 있다 model은 글 작성이 완료되었다는 문구 표시를 위한

        boardService.write(board);
        
        // 글 작성이 완료되었다는 문구 출력
        model.addAttribute("message", "글 작성이 완료되었습니다.");
        model.addAttribute("searchUrl","/board/list");

        return "message";
    }
    //게시글 리스트
    @GetMapping("/board/list")
    public String boardList(Model model){       //데이터를 담아서 페이지로 보내주는 역할 = model

        model.addAttribute("list", boardService.boardList()); //list라는 이름으로 메소드의 반환값을 넘기겠다

        return "boardlist";
    }

    //게시글 상세 페이지
    @GetMapping("/board/view") // localhost:8080/board/view?id=1 -> 1번째 게시글 불러온다
    public String boardView(Model model, Integer id){

        model.addAttribute("board", boardService.boardView(id));
        return "boardview";
    }

    //게시글 삭제
    @GetMapping("/board/delete")
    public String boardDelete(Integer id){

        boardService.boardDelete(id);

        return "redirect:/board/list";
    }
    //수정 페이지
    @GetMapping("/board/modify/{id}")
    public String boardModify(@PathVariable("id") Integer id,
                                                    Model model){
        //url이 들어왔을 때 뒤의 id가 @PathVariable에 인식이 되서 Integer형태의 id가 된다

        //값을 넘겨줌
        model.addAttribute("board", boardService.boardView(id));
        return "boardmodify";
    }

    //버튼 누르면 수정되게
    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id, Board board, Model model){  //Board객체를 만든 이유는 id와 content값을 불러와야 해서

        Board boardTemp = boardService.boardView(id); //기존에 있던 글 검색
        boardTemp.setTitle(board.getTitle());   //새로운 내용 덮어 씌우기
        boardTemp.setContent(board.getContent());
        model.addAttribute("message", "수정되었습니다");
        model.addAttribute("searchUrl", "/board/list");
        boardService.write(boardTemp); //저장

        return "message";
    }

}

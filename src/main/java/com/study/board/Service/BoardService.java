package com.study.board.Service;

import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired //Spring에서는 알아서 읽어와 객체를 주입해준다
    private BoardRepository boardRepository;

    //글 작성 처리
    public void write(Board board){

        boardRepository.save(board);
    }

    //글 불러올 method(게시글 리스트 처리)
    public List<Board> boardList(){

        return boardRepository.findAll(); //board 클래스가 담긴 List를 반환
    }

    //특정 게시글 불러오기
    public Board boardView(Integer id){

        return boardRepository.findById(id).get();
    }

    //특정 게시글 삭제
    public void boardDelete(Integer id){

        boardRepository.deleteById(id);
    }

}

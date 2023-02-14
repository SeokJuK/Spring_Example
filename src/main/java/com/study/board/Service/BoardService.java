package com.study.board.Service;

import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired //Spring에서는 알아서 읽어와 객체를 주입해준다
    private BoardRepository boardRepository;
    public void write(Board board){

        boardRepository.save(board);
    }
}

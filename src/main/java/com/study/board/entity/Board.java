package com.study.board.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// table이름과 일치해야 좋다 -> Entity는 db의 table을 의미한다
@Entity //JPA가 읽어 처리
@Data //BoardController에서 값을 읽어올 수 있게 하려고 사용
public class Board {
    @Id //pkey를 의미
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;  //id,title,content는 sql board table의 Column name이다


}

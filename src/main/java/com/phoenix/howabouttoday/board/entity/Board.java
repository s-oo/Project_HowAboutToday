package com.phoenix.howabouttoday.board.entity;

import com.phoenix.howabouttoday.board.dto.BoardDTO;
import com.phoenix.howabouttoday.board.dto.FAQAddDTO;
import com.phoenix.howabouttoday.member.entity.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Getter
@Entity
public class Board {

    // 게시판 : Notice, FAQ, About Us

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNum; // 게시글 번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_num")
    private Member member; // 회원 번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_category_num")
    private BoardCategory boardCategory; // 게시글 카테고리 번호

    @Column(nullable = false)
    private String boardTitle; // 게시글 제목

    @Column(nullable = false, length = 20000, columnDefinition = "TEXT")
    private String boardContent; // 게시글 내용

    @CreatedDate
    @Column
    private LocalDate boardCreate; // 게시일

    // (Notice, About Us) 게시글 작성
    public Board(Member member, BoardCategory boardCategory, BoardDTO boardDTO) {
        this.member = member;
        this.boardCategory = boardCategory;
        this.boardTitle = boardDTO.getBoardTitle();
        this.boardContent = boardDTO.getBoardContent();
        this.boardCreate = LocalDate.now();
    }

    // FAQ 게시글 작성
    public Board(Member member, BoardCategory boardCategory, FAQAddDTO FAQAddDTO) {
        this.member = member;
        this.boardCategory = boardCategory;
        this.boardTitle = FAQAddDTO.getBoardTitle();
        this.boardContent = FAQAddDTO.getBoardContent();
        this.boardCreate = LocalDate.now();
    }

    // (Notice, About Us) 게시글 수정
    public void editBoard(Long boardNum, BoardDTO boardDTO) {
        this.boardNum = boardNum;
        this.boardTitle = boardDTO.getBoardTitle();
        this.boardContent = boardDTO.getBoardContent();
    }

    // FAQ 게시글 수정
    public void editFAQ(Long boardNum, FAQAddDTO FAQAddDTO) {
        this.boardNum = boardNum;
        this.boardCategory = boardCategory;
        this.boardTitle = FAQAddDTO.getBoardTitle();
        this.boardContent = FAQAddDTO.getBoardContent();
    }
}

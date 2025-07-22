package org.koreait.board.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.koreait.global.entities.BaseEntity;
import org.koreait.member.constants.Authority;

@Data
@Entity
public class Board extends BaseEntity {
    @Id
    private String bid;
    private String name; //  게시판 이름
    private int rowsForPage; // 한 페이지 당 레코드 갯수
    private int pageCount; // 노출된 페이지 갯수
    private String skin; // 게시판 스킨



    private boolean active; // 게시판 사용 여부 true , false 미사용
    private boolean editor; //
    private boolean useEditor;//  에티터 사용 여부
    private boolean useImageUpload; //  에디터 이미지 추가 기능 사용 여부
    private boolean useAttachFile;// 파일 첨부 기능 사용 여부

    private Authority listAuthority; // 목록 권한 All 전체 , Member 회원  admin 관리자
    private Authority ViewAuthority;// 글 보기 권한
    private Authority wirtAuthority; // 글 작성 권한
    private Authority commentAuthority; //  댓글 작성 권한

}

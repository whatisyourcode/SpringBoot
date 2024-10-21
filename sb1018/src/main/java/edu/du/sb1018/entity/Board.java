package edu.du.sb1018.entity;

import lombok.*;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_board")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer boardIdx;

    private String title;

    private String contents;

    private int hitCnt;

    @Column(nullable = false)
    private String creatorId;

    @Column(nullable = false)
    private String createdDatetime;

    private String updaterId;

    private String updatedDatetime;

    @Column(nullable = false)
    private String deletedYn;

    public Board(Integer boardIdx, String title, String contents, int hitCnt, String createdDatetime, String creatorId) {
        this.boardIdx = boardIdx;
        this.title = title;
        this.contents = contents;
        this.hitCnt = hitCnt;
        this.createdDatetime = createdDatetime;
        this.creatorId = creatorId;
    }

    // @PrePersist : 엔티티가 처음으로 데이터베이스에 저장되기 전에 호출되는 메서드로, 여기서 Not NUll 제약조건 필드를 초기화.
    @PrePersist
    public void prePersist() {
        createdDatetime = String.valueOf(LocalDateTime.now());
        creatorId = "admin";
        deletedYn = "N";
    }



}

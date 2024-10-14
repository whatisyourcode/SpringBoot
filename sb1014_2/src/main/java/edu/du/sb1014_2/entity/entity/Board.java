package edu.du.sb1014_2.entity.entity;

import lombok.*;

import javax.persistence.*;

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

    private String creatorId;

    private String createdDatetime;

    private String updaterId;

    private String updatedDatetime;

    private String deletedYn;

    public Board(Integer boardIdx, String title, String contents, int hitCnt, String createdDatetime, String creatorId) {
        this.boardIdx = boardIdx;
        this.title = title;
        this.contents = contents;
        this.hitCnt = hitCnt;
        this.createdDatetime = createdDatetime;
        this.creatorId = creatorId;
    }
}

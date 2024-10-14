package edu.du.sb1014_2.entity.repository;

import edu.du.sb1014_2.entity.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
=======
import org.springframework.data.jpa.repository.Query;

>>>>>>> 45cae153271cc652b263d717d2552c785d3542bf
import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    @Query("SELECT new Board(b.boardIdx,b.title,b.contents,b.hitCnt,b.creatorId,b.createdDatetime,b.updaterId,b.updatedDatetime,b.deletedYn)" +
            "  FROM Board b WHERE b.deletedYn = 'N' ORDER BY b.boardIdx DESC")
    List<Board> selectBoardList();

<<<<<<< HEAD
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO t_board(title, contents, createdDatetime, creator_id) " +
            "VALUES(:#{#board.title}, :#{#board.contents}, NOW(), 'admin')",
            nativeQuery = true)
    void insertBoard(@Param("board") Board board);

    @Query("SELECT new Board(b.boardIdx, b.title, b.contents, b.hitCnt, b.createdDatetime, b.creatorId) " +
            "FROM Board b WHERE b.boardIdx = :boardIdx AND b.deletedYn = 'N'")
    Board selectBoardDetail(@Param("boardIdx") Integer boardIdx);
}

=======

}
>>>>>>> 45cae153271cc652b263d717d2552c785d3542bf

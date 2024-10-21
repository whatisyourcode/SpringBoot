package edu.du.sb1014_2.repository;

import edu.du.sb1014_2.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import javax.transaction.Transactional;
import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    @Query("SELECT new Board(b.boardIdx,b.title,b.contents,b.hitCnt,b.creatorId,b.createdDatetime,b.updaterId,b.updatedDatetime,b.deletedYn)" +
            "  FROM Board b WHERE b.deletedYn = 'N' ORDER BY b.boardIdx DESC")
    List<Board> selectBoardList();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO t_board(title, contents, created_datetime, creator_id,hit_cnt,deleted_yn) " +
            "VALUES(:#{#board.title}, :#{#board.contents}, NOW(), 'admin',0, 'N')",
            nativeQuery = true)
    void insertBoard(@Param("board") Board board);


    @Query("SELECT new Board(b.boardIdx, b.title, b.contents, b.hitCnt, b.createdDatetime, b.creatorId) " +
            "FROM Board b WHERE b.boardIdx = :boardIdx AND b.deletedYn = 'N'")
    Board selectBoardDetail(@Param("boardIdx") Integer boardIdx);


    @Modifying
    @Transactional
    @Query("UPDATE Board b SET b.hitCnt = b.hitCnt + 1 WHERE b.boardIdx = :boardIdx")
    public void hitCountUp(@Param("boardIdx") Integer boardIdx);


    @Modifying
    @Transactional
    @Query(value = "UPDATE Board b SET b.title = :#{#board.title}, b.contents = :#{#board.contents}, " +
            "b.updatedDatetime = NOW(), b.updaterId = :#{#board.updaterId} " +
            "WHERE b.boardIdx = :#{#board.boardIdx}")
    void updateBoard(@Param("board") Board board);


    @Modifying
    @Transactional
    @Query(value= "DELETE FROM Board b WHERE b.boardIdx = :boardIdx")
    void deleteBoard(@Param("boardIdx") Integer boardIdx);
}

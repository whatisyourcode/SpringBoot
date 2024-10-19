package edu.du.sb1014_2.service;



import edu.du.sb1014_2.entity.entity.Board;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.ModelAttribute;
=======
<<<<<<< HEAD
import org.springframework.web.bind.annotation.ModelAttribute;
=======
>>>>>>> 45cae153271cc652b263d717d2552c785d3542bf
>>>>>>> d4d7ae16605d49bd7a5a1ef84769e5ca736d2c50

import java.util.List;

public interface BoardService {
	
	List<Board> selectBoardList() throws Exception;
	
	void insertBoard(Board board) throws Exception;

	Board selectBoardDetail(int boardIdx) throws Exception;

	void updateBoard(Board board) throws Exception;

	void deleteBoard(int boardIdx) throws Exception;
}

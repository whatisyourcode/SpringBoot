package edu.du.sb1014_2.service;



import edu.du.sb1014_2.entity.entity.Board;
import edu.du.sb1014_2.entity.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Override
	public List<Board> selectBoardList() throws Exception {
		return boardRepository.selectBoardList();
	}
	
	@Override
	public void insertBoard(Board board) throws Exception {
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> d4d7ae16605d49bd7a5a1ef84769e5ca736d2c50
		System.out.println("Board Title: " + board.getTitle());
		System.out.println("Board Contents: " + board.getContents());
		System.out.println("Creator ID: " + board.getCreatorId());
	 	boardRepository.insertBoard(board);
<<<<<<< HEAD
=======
=======
	// 	boardRepository.insertBoard(board);
>>>>>>> 45cae153271cc652b263d717d2552c785d3542bf
>>>>>>> d4d7ae16605d49bd7a5a1ef84769e5ca736d2c50
	}

	@Override
	public Board selectBoardDetail(int boardIdx) throws Exception{
<<<<<<< HEAD
		Board board = boardRepository.selectBoardDetail(boardIdx);
		// board.updateHitCount(boardIdx);
=======
<<<<<<< HEAD
		Board board = boardRepository.selectBoardDetail(boardIdx);
		// board.updateHitCount(boardIdx);
=======

		Board board = new Board();
		//		Board board = boardRepository.selectBoardDetail(boardIdx);
//		board.updateHitCount(boardIdx);

>>>>>>> 45cae153271cc652b263d717d2552c785d3542bf
>>>>>>> d4d7ae16605d49bd7a5a1ef84769e5ca736d2c50
		return board;
	}
	
	@Override
	public void updateBoard(Board board) throws Exception {
	//	boardRepository.updateBoard(board);
	}

	@Override
	public void deleteBoard(int boardIdx) throws Exception {
	//	boardRepository.deleteBoard(boardIdx);
	}
}	


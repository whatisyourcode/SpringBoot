package edu.du.sb1014_2.service;



import edu.du.sb1014_2.entity.Board;
import edu.du.sb1014_2.repository.BoardRepository;
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

//		System.out.println("Board Title: " + board.getTitle());
//		System.out.println("Board Contents: " + board.getContents());
//		System.out.println("Creator ID: " + board.getCreatorId());
	 	boardRepository.insertBoard(board);
	}

	@Override
	public Board selectBoardDetail(int boardIdx) throws Exception{
		Board board = boardRepository.selectBoardDetail(boardIdx);
		// board.updateHitCount(boardIdx);
		return board;
	}
	
	@Override
	public void updateBoard(Board board) throws Exception {
		boardRepository.updateBoard(board);
	}

	@Override
	public void deleteBoard(int boardIdx) throws Exception {
		boardRepository.deleteBoard(boardIdx);
	}

	@Override
	public void hitCountUp(int boardIdx) throws Exception {
		boardRepository.hitCountUp(boardIdx);
	}
}	


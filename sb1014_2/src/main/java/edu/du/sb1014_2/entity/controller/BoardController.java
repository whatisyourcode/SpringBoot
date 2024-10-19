package edu.du.sb1014_2.entity.controller;


import edu.du.sb1014_2.entity.entity.Board;
import edu.du.sb1014_2.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;
=======
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;
=======
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
>>>>>>> 45cae153271cc652b263d717d2552c785d3542bf
>>>>>>> d4d7ae16605d49bd7a5a1ef84769e5ca736d2c50

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/")
    public String index() {
        return "redirect:/board/openBoardList.do";
    }

    @GetMapping("/board/openBoardList.do")
    public String openBoardList(Model model) throws Exception {
        List<Board> list = boardService.selectBoardList();
        model.addAttribute("list", list);
        return "/board/boardList";
    }

    @RequestMapping("/board/openBoardWrite.do")
    public String openBoardWrite() throws Exception{
        return "/board/boardWrite";
    }

<<<<<<< HEAD
    @PostMapping("/board/insertBoard.do")
    public String insertBoard(@ModelAttribute Board board) throws Exception{
        boardService.insertBoard(board);
=======
<<<<<<< HEAD
    @PostMapping("/board/insertBoard.do")
    public String insertBoard(@ModelAttribute Board board) throws Exception{
        boardService.insertBoard(board);
=======
    @RequestMapping("/board/insertBoard.do")
    public String insertBoard(Board board) throws Exception{
//		boardService.insertBoard(board);
>>>>>>> 45cae153271cc652b263d717d2552c785d3542bf
>>>>>>> d4d7ae16605d49bd7a5a1ef84769e5ca736d2c50
        return "redirect:/board/openBoardList.do";
    }

    @GetMapping("/board/openBoardDetail.do")
    public String openBoardDetail(@RequestParam int boardIdx, Model model) throws Exception{
<<<<<<< HEAD
		Board board = boardService.selectBoardDetail(boardIdx);
		model.addAttribute("board", board);
=======
<<<<<<< HEAD
		Board board = boardService.selectBoardDetail(boardIdx);
		model.addAttribute("board", board);
=======
//		Board board = boardService.selectBoardDetail(boardIdx);
//		model.addAttribute("board", board);
>>>>>>> 45cae153271cc652b263d717d2552c785d3542bf
>>>>>>> d4d7ae16605d49bd7a5a1ef84769e5ca736d2c50
        return "/board/boardDetail";
    }

    @RequestMapping("/board/updateBoard.do")
    public String updateBoard(Board board) throws Exception{
//		boardService.updateBoard(board);
        return "redirect:/board/openBoardList.do";
    }

    @RequestMapping("/board/deleteBoard.do")
    public String deleteBoard(int boardIdx) throws Exception{
        boardService.deleteBoard(boardIdx);
        return "redirect:/board/openBoardList.do";
    }
}
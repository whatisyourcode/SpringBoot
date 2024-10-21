package edu.du.sb1018.controller;

import edu.du.sb1018.Service.BoardService;
import edu.du.sb1018.entity.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    // @Autowired를 사용하지 않고 생성자를 이용하여 자동주입 받기.(성능 이슈)
    final BoardService boardService;

    @GetMapping("/")
    public String index() {
        return "redirect:/board/openBoardList.do";
    }

    // 게시판 리스트
    @GetMapping("/board/openBoardList.do")
    public String openBoardList(Model model){
        List<Board> list = boardService.selectAllBoard();
        model.addAttribute("list", list);
        return "board/boardList";
    }

    // 게시판 폼
    @GetMapping("/board/openBoardWrite.do")
    public String openBoardWrite(Model model){
        return "board/boardWrite";
    }

    // 게시판 폼 작성
    @PostMapping("/board/insertBoard.do")
    public String insertBoard(@ModelAttribute Board board, Model model){
        boardService.insertBoard(board);
        return "redirect:/";
    }

    // 게시판 글
    @GetMapping("/board/openBoardDetail.do")
    public String boardDetail(Model model, @RequestParam("boardIdx")  Integer boardIdx){
        Board board = boardService.selectBoardById(boardIdx);
        model.addAttribute("board", board);
        return "board/boardDetail";
    }

    @PostMapping("/board/updateBoard.do")
    public String updateBoard(@ModelAttribute Board board) {
        boardService.updateBoard(board);
        return "redirect:/";
    }

    @PostMapping("/board/deleteBoard.do")
    public String deleteBoard(@RequestParam("boardIdx") Integer boardIdx){
        boardService.deleteBoard(boardIdx);
        return "redirect:/";
    }
}

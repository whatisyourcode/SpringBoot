package edu.du.sb1014_2;

import edu.du.sb1014_2.entity.entity.Board;
import edu.du.sb1014_2.entity.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Sb10142ApplicationTests {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void selectAll(){
        for(Board board : boardRepository.selectBoardList()){
            System.out.println(board);
        }
    }

}

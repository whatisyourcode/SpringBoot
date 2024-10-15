package edu.du.sb1015_2;

import edu.du.sb1015_2.entity.MyData;
import edu.du.sb1015_2.repository.MyDataRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class Sb10152ApplicationTests {

    @Autowired
    MyDataRepository myDataRepository;

    @Test
    void 데이터_다_가져오기() {
        List<MyData> list = myDataRepository.findAll();
        for(MyData myData : list){
            System.out.println(myData);
        }
    }

    @Test
    void 데이터_하나_가져오기() {
        Optional<MyData> myData = myDataRepository.findById(1L);
        System.out.println(myData);
    }

    @Test
    void 데이터_삭제하기(){
        myDataRepository.deleteById(1L);
        if(!(myDataRepository.existsById(1L))){
            System.out.println("데이터가 없습니다.");
        }
    }



}

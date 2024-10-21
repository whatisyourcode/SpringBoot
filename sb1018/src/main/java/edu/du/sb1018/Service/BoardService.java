package edu.du.sb1018.Service;


import edu.du.sb1018.entity.Board;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.rmi.server.ExportException;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class BoardService {

    @PersistenceUnit
    private EntityManagerFactory emf;

    public List<Board> selectAllBoard(){
        // 트랜잭션 시작
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        List<Board> list = null;
        try {
            transaction.begin();

            TypedQuery<Board> query = em.createQuery("SELECT b FROM Board b", Board.class);
            list = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }

        return list;
    }

    public void insertBoard(Board board){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try{
            transaction.begin();
            em.persist(board);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }
    }

    public Board selectBoardById(int boardIdx){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        Board board = null;
        try{
            transaction.begin();
            board = em.find(Board.class, boardIdx);
            transaction.commit();
        } catch(Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        return board;
    }

    public void updateBoard(Board board){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            // board 에 not null 규정이 너무 많아서 새로운 board로 merge()로 넘기게 되면 에러가 발생했다.
            // 그래서 기존 데이터베이스에 존재하는 existingBoard를 가져온다.
            Board existingBoard = em.find(Board.class, board.getBoardIdx());
            // board에 전송된 데이터를 existingBoard에 update 해준다.
            existingBoard.setTitle(board.getTitle());
            existingBoard.setContents(board.getContents());
            // merge()
            em.merge(existingBoard);
            transaction.commit();
        } catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void deleteBoard(int boardIdx){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Board board = em.find(Board.class, boardIdx);
            em.remove(board);
            transaction.commit();
        } catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

}

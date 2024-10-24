package edu.du.sb1023;

import edu.du.sb1023.entity.Member;
import edu.du.sb1023.entity.Team;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import java.util.List;

@SpringBootTest
class Sb1023ApplicationTests {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Test
    void test_Save(){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Member person1 = new Member("person1","사람1");
        Member person2 = new Member("person2","사람2");
        Team pteam  = new Team("pteam","p팀");

        person1.setTeam(pteam);
        person2.setTeam(pteam);

        em.persist(person1);
        em.persist(person2);
        em.persist(pteam);

        transaction.commit();
    }


    @Test
    void test_Find(){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        // 조회
        String jpql = "select m from Member m join m.team t where t.name=:teamName";
        List<Member> members = em.createQuery(jpql, Member.class)
                        .setParameter("teamName","p팀")
                        .getResultList();
        // 반복문

        for(Member member : members){
            System.out.println(member);
        }
        transaction.commit();
    }

    @Test
    void test_Find2(){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Member member = em.find(Member.class, "person1");
        System.out.println(member);
        System.out.println("팀 이름 :" +member.getTeam().getName());

        transaction.commit();
    }

    @Test
    void test_update(){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        //새로운 팀2
        Team team2 = new Team("team2","팀2");
        em.persist(team2);

        // 회원1에 새로운 팀2 설정해 보세요
        em.find(Member.class, "person1").setTeam(team2);

        transaction.commit();
    }

    @Test
    void test_연관관계제거(){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Member member1 =em.find(Member.class, "person1");
        member1.setTeam(null);

        transaction.commit();
    }

    @Test
    void test_연관된_엔티티_제거(){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        // 팀2 삭제
//        Team team2 = em.find(Team.class, "team2");
//        em.remove(team2);

        // 팀1 삭제
        Team pteam = em.find(Team.class, "pteam");
        Member member = em.find(Member.class, "person2");
        member.setTeam(null);

        em.remove(pteam);

        transaction.commit();
    }

    @Test
    void test_양방향_탐색(){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Team team = em.find(Team.class, "pteam");
        for(Member member : team.getMembers()){
            System.out.println(member.getUsername());
        }


        transaction.commit();
    }



    @Test
    void test_순수객체() {
        Member member1 = new Member("member1","회원1");
        Member member2 = new Member("member2","회원2");
        Team team = new Team("team1","팀1");

        member1.setTeam(team);
        member2.setTeam(team);
        System.out.println(member1);
        System.out.println(member2);

    }

}

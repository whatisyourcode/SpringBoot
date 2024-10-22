package edu.du.sb1022secuFinal.repository;

import edu.du.sb1022secuFinal.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;



public interface MemberRepository extends JpaRepository<Member, Long> {
        Member findByName(String name);
}

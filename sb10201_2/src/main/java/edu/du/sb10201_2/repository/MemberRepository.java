package edu.du.sb10201_2.repository;

import edu.du.sb10201_2.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;


public interface MemberRepository extends JpaRepository<Member, Long> {

}

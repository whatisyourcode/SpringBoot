package edu.du.sb1022secuFinal.entity;

import edu.du.sb1022secuFinal.spring.WrongIdPasswordException;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Table(name="member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String name;
    private LocalDateTime regdate;

    public Member(String email, String password, String name, LocalDateTime regdate) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.regdate = regdate;
    }

    public void changePassword(String oldPassword, String newPassword) {
        if (!password.equals(oldPassword))
            throw new WrongIdPasswordException();
        this.password = newPassword;
    }
}

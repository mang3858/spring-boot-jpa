package hellojpa;

import jakarta.persistence.*;

import java.util.Date;

@Entity //얘가 있어야 JPA가 관리해야하는 애라고 인식함
//@Table(name = "MBR") ; 테이블 명이 디비(MBR)와 코드(Member)가 다를 때
@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq")
public class Member {

    @Id //primary key 선언하기
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq")
    private Long id;
    @Column(name = "name")
    private String username;

  public Member() {

  }

  public Long getId() {
      return id;
  }

  public void setId(Long id) {
      this.id = id;
  }

  public String getUsername() {
      return username;
  }

  public void setUsername(String username) {
      this.username = username;
  }

}
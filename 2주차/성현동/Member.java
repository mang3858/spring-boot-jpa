package hellojpa;

import jakarta.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
//@Table(name ="MBR") 테이블명 변경하고 싶을때 name 사용
public class Member {

    @Id //primary key 선언하기
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
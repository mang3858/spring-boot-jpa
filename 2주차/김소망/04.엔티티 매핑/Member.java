package hellojpa;

import jakarta.persistence.*;

//처음 로딩될 때 jpa가 사용하는거구나를 인식하므로 꼭 넣어줘야 함; JPA가 관리할 객체
@Entity
public class Member {

    //pk 매핑
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //객체는 username을 쓰고 싶은데 db 에는 named이라고 써야 할 때
    //@Column의 name 속성 쓰면 됨
    @Column(name = "name", nullable = false)
    private String username;

    public Member(){
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

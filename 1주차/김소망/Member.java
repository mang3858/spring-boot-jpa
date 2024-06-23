package hellojpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//처음 로딩될 때 jpa가 사용하는거구나를 인식하므로 꼭 넣어줘야 함; JPA가 관리할 객체
@Entity
//@Table(name = "USER")
public class Member {

    //jpa한테 PK가 무엇인지 알려줘야 함; 데이터베이스 PK와 매핑
    @Id
    //객체와 테이블을 생성하고 매핑
    private Long id;

    //@Column(name = "username")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

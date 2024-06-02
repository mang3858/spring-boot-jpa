package hellojpa;

import jakarta.persistence.*;

@Entity
public class Team {
    @Id
    @GeneratedValue
    private Long id;
    private String name;…

    @OneToMany(mappedBy = "team") // db상에서 fk가 여기 없으므로 양방향관계의 주인x.(가짜맵핑)
    List<Member> members = new ArrayList<Member>(); // 읽기전용
}
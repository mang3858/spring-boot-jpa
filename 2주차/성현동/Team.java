package hellojpa;

import jakarta.persistence.*;

@Entity
public class Team {
    @Id
    @GeneratedValue
    private Long id;
    private String name;…

    @OneToMany(mappedBy = "team") // 양방향은 필요할때만 추가하고, 단방향맵핑으로 웬만하면 끝내라.
    List<Member> members = new ArrayList<Member>(); // 읽기전용
}
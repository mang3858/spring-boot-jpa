package hellojpa;

import jakarta.persistence.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id @GeneratedValue @Column(name = "TEAM_ID")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "team") //단순히 읽기만 가능
    private List<Member> members = new ArrayList<>();

    public Long getId() {
        return id;
    }
//
//    public void addMember(Member member){
//        member.setTeam(this);
//        members.add(member);
//    }

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
package hellojpa;

import jakarta.persistence.*;

import java.util.Date;

@Entity //얘가 있어야 JPA가 관리해야하는 애라고 인식함
//@Table(name = "MBR") ; 테이블 명이 디비(MBR)와 코드(Member)가 다를 때
//@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq")
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")//primary key 선언하기
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;
//    @Column(name = "TEAM_ID")
//    private Long teamId;

//    private Integer age;
//
//    @Enumerated(EnumType.STRING)
//    private RoleType roleType;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createDate;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//
//    @Lob
//    private String description;

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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
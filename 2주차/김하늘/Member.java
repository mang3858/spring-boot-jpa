package hellojpa;

import jakarta.persistence.*;

import java.util.Date;

@Entity //얘가 있어야 JPA가 관리해야하는 애라고 인식함
//@Table(name = "MBR") ; 테이블 명이 디비(MBR)와 코드(Member)가 다를 때
public class Member {

    @Id //primary key 선언하기
    private Long id;
//    @Column(name = "name")
    private String username;

    public Member() {

    }
    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    //getter and setter 단축키 : Alt + Insert
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
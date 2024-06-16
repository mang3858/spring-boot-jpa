package hellojpa;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.*;

@Entity //얘가 있어야 JPA가 관리해야하는 애라고 인식함
//@Table(name = "MBR") ; 테이블 명이 디비(MBR)와 코드(Member)가 다를 때
//@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq")
public class Member{

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")//primary key 선언하기
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Embedded
    private Period workPeriod;
    @Embedded
    private Address homeAddress;

    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD", joinColumns =
    @JoinColumn(name = "MEMBER_ID"))
    @Column(name = "FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "ADDRESS", joinColumns =
    @JoinColumn(name = "MEMBER_ID"))
    private List<Address> addressHistory = new ArrayList<>();
//
//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "city",
//            column = @Column(name = "work_city")),
//            @AttributeOverride(name = "street",
//                    column = @Column(name = "work_street")),
//            @AttributeOverride(name = "zipcode",
//                    column = @Column(name = "work_zipcode"))
//    })
//    private Address workAddress;

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

    public Period getWorkPeriod() {
        return workPeriod;
    }

    public void setWorkPeriod(Period workPeriod) {
        this.workPeriod = workPeriod;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Set<String> getFavoriteFoods() {
        return favoriteFoods;
    }

    public void setFavoriteFoods(Set<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
    }

    public List<Address> getAddressHistory() {
        return addressHistory;
    }

    public void setAddressHistory(List<Address> addressHistory) {
        this.addressHistory = addressHistory;
    }
}
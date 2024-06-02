package hellojpa;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "username") // unique 조건은 이렇게 테이블 단위로 거는거 추천

})
public class Member {
    @Id
    private Long id;
    @Column(name = "name",nullable = false) // unique = true는 여기서 사용하는거 비추
    private String username;
    private Integer age;
    @Enumerated(EnumType.STRING)  // DB에는 enum타입이 없음, EnumType.ORDINAL 쓰지마라!
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP) // TemporalType = 날짜. 근데 이거 옛날 버젼
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    private LocalDate localDate; // 이게 요즘 hibernate 날짜
    private LocalDateTime localDateTime;
    @Lob  // 엄청 큰 데이터에 대해서 관리하고 싶을때(문자열은 Clob, 나머지는 Blob)
    private String description;

    @Transient  // JPA로부터 독립적으로 관리하고 싶은 변수
    private int item;
}
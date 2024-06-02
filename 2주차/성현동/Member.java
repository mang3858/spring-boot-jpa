package hellojpa;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "username") // unique 조건은 이렇게 테이블 단위로 거는거 추천

})
@SequenceGenerator(
        name= "member_seq_generator",
        sequenceName = "member_seq",
        initialValue = 1,
        allocationSize = 50 // 디폴트. 메모리에 한번에 50개 올려놓고 다 소진될때까지 MEMBER_SEQ 테이블 호출안함(성능최적화)
)
//GenerationType을 Sequence로 할때 생성기 정의
public class Member {
    @Id // 권장 : 타입은 Long형, 대체키(비즈니스와 무관한 랜덤값) 생성전략 사용
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Identity: db에 pk 관리 위임 -> 그러나, pk값을 알아야 영속성컨텍스트 저장이 가능하므로, 이 정책 사용시 "persist" 시점 = db저장
    // Sequence: @SeqeunceGenerator 사용해 생성기를 만들고 거기서 키를 생성받아 사용 -> 얘는 영속성 컨텍스트 버퍼링 가능.
    private Long id; // Integer로 두는것의 두배
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
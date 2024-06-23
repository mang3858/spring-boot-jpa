package jpabook.jpashop.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Entity
public class Category extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    //parent의 상위 카테고리라는 개념이 있음
    //이 카테고리 같은 것도 셀프로 매칭하는 것이 가능
    //자식입장에선 부모가 하나
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

    //양방향으로 해서 CHILD도 만들 수 있음
    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    //중간 테이블을 만드는 것 임(매핑하는 것)
    //중간 테이블이 있다고 치고 내가 조인하는 것은 CATEGORY_ID, 반대쪽이 조인 해야 되는건 ITEM_ID라고 잡아주는 것
    @ManyToMany
    @JoinTable(name = "CATEGORY_ITEM",
            joinColumns = @JoinColumn(name = "CATEGORY_ID"),
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
    )
    private List<Item> items = new ArrayList<>();
}

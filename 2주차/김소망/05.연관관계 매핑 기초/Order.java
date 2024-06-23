package jpabook.jpashop.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    //누가 주문했는지 알아야하니까
    //엔티티에서 멤버 아이디 외래키 값을 맵핑해서 그대로 가지고 있었는데 아래 연관관계 매핑하면 되니까 이 코드 2줄은 필요없음
//    @Column(name = "MEMBER_ID")
//    private Long memberId;

    //멤버 입장에서는 하나의 회원은 여러 개의 주문을 할 수 있음
    @ManyToOne
    //MEMBER_ID랑 매핑
    @JoinColumn(name = "MEMBER_ID")
    private Member member;//이 member 참조가 ORDERS의 MEMBER_ID랑 매핑이 되는 것

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    private LocalDateTime orderDate;

    //ORDINAL 쓰면 나중에 순서 꼬일 수 있으므로 꼭 스트링 쓰기!
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}

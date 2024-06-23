package jpabook.jpashop.domain;

import jakarta.persistence.*;

import static jakarta.persistence.FetchType.LAZY;

@Entity
public class Delivery extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    //값타입
    @Embedded
    private Address address;
    private DeliveryStatus status;

    //Order랑 양방향 매핑
    @OneToMany(mappedBy = "delivery", fetch = LAZY)
    private Order order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public DeliveryStatus getStatus() {
        return status;
    }

    public void setStatus(DeliveryStatus status) {
        this.status = status;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}

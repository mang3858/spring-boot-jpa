package jpabook.jpashop.domain;

import jakarta.persistence.*;

@Entity
public class OrderItem extends BaseEntity{
    @Id @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    //외래키 값을 그대로 가지고 있는게 아니라 order와 item이라는 객체를 가지고 있음
    //그래서 나중에 order와 item 객체를 조회해서 필요하면 getOrder, getItem을 할 수 있음
    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    private int oderPrice;
    private int count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getOderPrice() {
        return oderPrice;
    }

    public void setOderPrice(int oderPrice) {
        this.oderPrice = oderPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

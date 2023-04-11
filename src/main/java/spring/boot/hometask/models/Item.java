package spring.boot.hometask.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @ManyToMany(mappedBy = "items")
    private List<Request> orders;

    public Item() {
    }

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int itemId) {
        this.id = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Request> getOrders() {
        return orders;
    }

    public void setOrders(List<Request> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
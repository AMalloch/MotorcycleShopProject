package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "baskets")
public class Basket {
    private int id;
    private Customer customer;
    private ArrayList<StockItem> stockItems;


    public Basket() {
    }

    public Basket(Customer customer) {
        this.customer = customer;
        this.stockItems = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToOne(fetch = FetchType.EAGER)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @OneToMany(mappedBy = "basket")
    public ArrayList<StockItem> getStockItems() {
        return stockItems;
    }

    public void setStockItems(ArrayList<StockItem> stockItems) {
        this.stockItems = stockItems;
    }

    public int countItemsInBasket(){
        if (stockItems == null){
            return 0;
        }
        return stockItems.size();
    }
}

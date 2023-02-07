package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;
    private Status status;
    private Store_Stock stock;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Store_Stock getStock() {
        return stock;
    }

    public void setStock(Store_Stock stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Store: " + "\n" +
                "id: " + id + "\n" +
                "name: " + name + "\n" +
                "address: " + address + "\n" +
                "status: " + status + "\n" +
                "stock: " + stock + "\n";
    }
}

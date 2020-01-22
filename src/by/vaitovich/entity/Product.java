package by.vaitovich.entity;

import java.util.Date;
import java.util.Objects;

public class Product {

    private int price;
    private int oldPrice;
    private String id;
    private String title;
    private String code;
    private String characteristics;
    private String brand;
    private Date datetime;
    private String description;


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(int oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price &&
                oldPrice == product.oldPrice &&
                Objects.equals(id, product.id) &&
                Objects.equals(title, product.title) &&
                Objects.equals(code, product.code) &&
                Objects.equals(characteristics, product.characteristics) &&
                Objects.equals(brand, product.brand) &&
                Objects.equals(datetime, product.datetime) &&
                Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, oldPrice, id, title, code, characteristics, brand, datetime, description);
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", oldPrice=" + oldPrice +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", characteristics='" + characteristics + '\'' +
                ", brand='" + brand + '\'' +
                ", datetime=" + datetime +
                ", description='" + description + '\'' +
                '}';
    }
}

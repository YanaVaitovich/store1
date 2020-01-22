package by.vaitovich.entity;
import java.util.List;
import java.util.Objects;


public class Order {

    private String id;
    private List<Product> products;
    private User user;
    private String phone;
    private String address;
    private String comment;
    private Status status;
    private String cansel;
    private String cause;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCansel() {
        return cansel;
    }

    public void setCansel(String cansel) {
        this.cansel = cansel;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(products, order.products) &&
                Objects.equals(user, order.user) &&
                Objects.equals(phone, order.phone) &&
                Objects.equals(address, order.address) &&
                Objects.equals(comment, order.comment) &&
                status == order.status &&
                Objects.equals(cansel, order.cansel) &&
                Objects.equals(cause, order.cause);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, products, user, phone, address, comment, status, cansel, cause);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", products=" + products +
                ", user=" + user +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", comment='" + comment + '\'' +
                ", status=" + status +
                ", cansel='" + cansel + '\'' +
                ", cause='" + cause + '\'' +
                '}';
    }
}

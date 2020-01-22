package by.vaitovich.entity;
import java.util.Date;
import java.util.Objects;


public class User {

private String id;
    private String surname;
    private String name;
    private String patronymic;
    private String address;
    private String mail;
    private String phone;
    private String password;
    private Date registrationDate;
    private Role role;
    private boolean inBlackList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isInBlackList() {
        return inBlackList;
    }

    public void setInBlackList(boolean inBlackList) {
        this.inBlackList = inBlackList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return inBlackList == user.inBlackList &&
                Objects.equals(id, user.id) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(name, user.name) &&
                Objects.equals(patronymic, user.patronymic) &&
                Objects.equals(address, user.address) &&
                Objects.equals(mail, user.mail) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(password, user.password) &&
                Objects.equals(registrationDate, user.registrationDate) &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, patronymic, address, mail, phone, password, registrationDate, role, inBlackList);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", address='" + address + '\'' +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", registrationDate=" + registrationDate +
                ", role=" + role +
                ", inBlackList=" + inBlackList +
                '}';
    }
}

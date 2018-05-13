package ojss.domain;


import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass

public abstract class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column
    private String email;

    @Column
    private int postcode;

    @Column
    private String state;

    @Column
    private String address;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @Column
    private String suburb;

    @Column(name = "nick_name", unique = true)
    private String nickName;

    @Column(name = "pwd")
    private String password;

    public User(Long id, String exp, String email, String suburb, int postcode, String state, String address, Long phoneNumber, String userName, String password) {
        this.id = id;
        this.email = email;
        this.postcode = postcode;
        this.state = state;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.nickName = userName;
        this.password = password;
        this.suburb = suburb;
    }

    public User() {
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getUserName() {
        return nickName;
    }

    public void setUserName(String userName) {
        this.nickName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

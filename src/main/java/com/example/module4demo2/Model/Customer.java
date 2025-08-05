package com.example.module4demo2.Model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity                                                 // mark this is an entity
    @Table(name = "customer")                               // collate into database

public class Customer {
    @Id                                                     // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // auto increment
    private Long cusID;
    private String cusName;
    private String cusAddress;
    private String cusPhone;
    private String cusEmail;
    private String image;
//    private LocalDate cusBirthday;
//
//    public LocalDate getCusBirthday() {
//        return cusBirthday;
//    }
//
//    public void setCusBirthday(LocalDate cusBirthday) {
//        this.cusBirthday = cusBirthday;
//    }

    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;      // create new class and make it FK

    public Customer(String cusName, String cusAddress, String cusPhone, String cusEmail, String image) {
        this.cusName = cusName;
        this.cusAddress = cusAddress;
        this.cusPhone = cusPhone;
        this.cusEmail = cusEmail;
        this.image = image;
    }

        public Province getProvince() {
            return province;
        }

        public void setProvince(Province province) {
            this.province = province;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public Customer() {}

    public void setCusID(Long cusID) {
        this.cusID = cusID;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    public Long getCusID() {
        return cusID;
    }

    public String getCusName() {
        return cusName;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public String getCusEmail() {
        return cusEmail;
    }
    }



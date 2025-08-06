package com.example.module4demo2.Model;

import javax.persistence.*;
import javax.validation.ConstraintViolation;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.security.acl.Group;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Entity                                                 // mark this is an entity
    @Table(name = "customer")                               // collate into database

public class Customer implements Validator {
    @Id                                                     // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // auto increment
    private Long cusID;

    @NotEmpty(message = "name not empty", groups = BasicInfo.class)
    @Size(min = 2, max = 30, message = "length from 2 to 30", groups = BasicInfo.class)
    private String cusName;

    @NotEmpty(message = "address not empty", groups = BasicInfo.class)
    @Size(min = 5, message = "length from 5 character", groups = BasicInfo.class)
    private String cusAddress;

    @NotEmpty(message = "phone not empty", groups = BasicInfo.class)
    @Size(min = 10, message = "length from 10 character", groups = BasicInfo.class)
    private String cusPhone;

    @NotEmpty(message = "email not empty", groups = AdvanceInfo.class)
    @Size(min = 10, message = "length from 10 character", groups = AdvanceInfo.class)
    private String cusEmail;

    @NotEmpty(message = "image not empty", groups = AdvanceInfo.class)
    private String image;

    private LocalDate cusBirthday;

    public LocalDate getCusBirthday() {
        return cusBirthday;
    }

    public void setCusBirthday(LocalDate cusBirthday) {
        this.cusBirthday = cusBirthday;
    }

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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}



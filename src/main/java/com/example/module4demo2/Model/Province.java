package com.example.module4demo2.Model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "province")           // 1 to many relation to customer(example: que quan, gioi tinh)
public class Province {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long ProvinceId;

    @NotEmpty(message = "province not empty", groups = BasicInfo.class)
    private String ProvinceName;

    public Province(Long provinceId, String provinceName) {
        ProvinceId = provinceId;
        ProvinceName = provinceName;
    }

    public Province() {
    }

    public Long getProvinceId() {
        return ProvinceId;
    }

    public String getProvinceName() {
        return ProvinceName;
    }

    public void setProvinceId(Long provinceId) {
        ProvinceId = provinceId;
    }

    public void setProvinceName(String provinceName) {
        ProvinceName = provinceName;
    }
}

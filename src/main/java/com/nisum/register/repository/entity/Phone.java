package com.nisum.register.repository.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "PHONE")
@EntityListeners(AuditingEntityListener.class)
public class Phone {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_phone")
    private Long idPhone;
    private String number;
    private String cityCode;
    private String countryCode;

    public Phone(){
    }

    public Long getIdPhone() {
        return idPhone;
    }

    public void setIdPhone(Long idPhone) {
        this.idPhone = idPhone;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id_phone =" + idPhone +
                ", number='" + number + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}

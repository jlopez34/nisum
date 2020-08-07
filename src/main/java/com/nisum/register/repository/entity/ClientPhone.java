package com.nisum.register.repository.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

@Entity
@Table(name = "client_phone")
@EntityListeners(AuditingEntityListener.class)
public class ClientPhone {
    @EmbeddedId
    private ClientPhoneId id;

    public ClientPhoneId getId() {
        return id;
    }

    public void setId(ClientPhoneId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ClientPhone{" +
                "id=" + id +
                '}';
    }
}

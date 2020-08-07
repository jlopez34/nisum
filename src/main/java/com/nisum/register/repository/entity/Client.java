package com.nisum.register.repository.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "CLIENT")
@EntityListeners(AuditingEntityListener.class)
public class Client {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id_client", updatable = false, nullable = false)
    private UUID idClient;
    private String name;
    private String email;
    private String password;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    @CreatedDate
    private Date created;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    @LastModifiedDate
    private Date modified;

    private Date last_login;
    private String token;
    private boolean active;

    @OneToMany
    @JoinTable
            (name="client_phone",
                    joinColumns = {@JoinColumn(name="id_client", insertable = false, updatable = false),
                            @JoinColumn(name="id_phone", insertable = false, updatable = false)}
            )
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Phone> phone;


    public Client() {
    }

    public UUID getIdClient() {
        return idClient;
    }

    public void setIdClient(UUID idClient) {
        this.idClient = idClient;
    }

    public Set<Phone> getPhone() {
        return phone;
    }

    public void setPhone(Set<Phone> phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Phone> getPhones() {
        return phone;
    }

    public void setPhones(Set<Phone> phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                ", last_login=" + last_login +
                ", token='" + token + '\'' +
                ", active=" + active +
                ", phone=" + phone +
                '}';
    }
}

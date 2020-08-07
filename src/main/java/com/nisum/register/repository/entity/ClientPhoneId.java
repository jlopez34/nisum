package com.nisum.register.repository.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class ClientPhoneId {
    @Column(name = "ID_CLIENT_PHONE" )
    private int idClientPhone;
    @Column(name = "ID_CLIENT" )
    private UUID idClient;
    @Column(name = "ID_PHONE" )
    private int idPhone;

    public int getIdClientPhone() {
        return idClientPhone;
    }

    public void setIdClientPhone(int idClientPhone) {
        this.idClientPhone = idClientPhone;
    }

    public UUID getIdClient() {
        return idClient;
    }

    public void setIdClient(UUID idClient) {
        this.idClient = idClient;
    }

    public int getIdPhone() {
        return idPhone;
    }

    public void setIdPhone(int idPhone) {
        this.idPhone = idPhone;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdClientPhone(), getIdClient(), getIdPhone());
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if( !(obj instanceof ClientPhoneId)) return false;
        ClientPhoneId that = (ClientPhoneId) obj;
        return Objects.equals(getIdClientPhone(), that.getIdClientPhone()) &&
                Objects.equals(getIdClient(), that.getIdClient()) &&
                Objects.equals(getIdPhone(), that.getIdPhone());
    }
}

package com.nisum.register.model;

import javax.validation.constraints.Pattern;
import java.util.List;

public class ClientRequest {
    private String name;
    
    @Pattern(regexp = ".+@.+\\..+", message = "Format email is invalid, should be similar to aaaaaaa@dominio.cl")
    private String email;

    @Pattern(regexp = "((?=.*[a-z])(?=.*d)(?=.*[A-Z]).{6,10})", message = "Password inserted does not compliment " +
            " with the standard rules")
    private String password;
    private List<PhoneRequest> phoneRequests;

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

    public List<PhoneRequest> getPhoneRequests() {
        return phoneRequests;
    }

    public void setPhoneRequests(List<PhoneRequest> phoneRequests) {
        this.phoneRequests = phoneRequests;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phones=" + phoneRequests +
                '}';
    }
}

package com.medicalstore.medicalstore.cmd.account.dmain.hibernate;

import com.medicalstore.medicalstore.cmd.role.domain.hibernate.RoleData;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AccountData {
    @Id
    private String accountId;
    private String name;
    private String email;
    private String phone;
    private String password;
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressData address;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleData role;

    // getters and setters

    public String getId() {
        return accountId;
    }

    public void setId(String accountId) {
        this.accountId = accountId;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public AddressData getAddress() {
        return address;
    }

    public void setAddress(AddressData address) {
        this.address = address;
    }

    public RoleData getRoleData() {
        return role;
    }

    public void setRoleData(RoleData role) {
        this.role = role;
    }

}

package com.anaju_martins.lojinha.domain.enums;

public enum UserRole {

    ADMIN("admin"),
    CUSTOMER("customer"),
    EDITOR("editor");

    private String role;

    UserRole(String role) { this.role = role; }

    public String getRole() { return role; }


}

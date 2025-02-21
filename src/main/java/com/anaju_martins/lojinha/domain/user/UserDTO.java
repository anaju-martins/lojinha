package com.anaju_martins.lojinha.domain.user;

public record UserDTO(String id, String name, String email) {
    public UserDTO(User user) {
        this(user.getId(), user.getName(), user.getEmail());
    }
}

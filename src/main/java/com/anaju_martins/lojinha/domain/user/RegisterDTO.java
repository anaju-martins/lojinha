package com.anaju_martins.lojinha.domain.user;

import com.anaju_martins.lojinha.domain.enums.UserRole;

public record RegisterDTO(String name, String email, String password, UserRole role) {
}

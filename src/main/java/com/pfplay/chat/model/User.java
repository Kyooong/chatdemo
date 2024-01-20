package com.pfplay.chat.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class User {
    private Long id;
    private String email;
    private String nickname;

    private String introduction;
    private Authority authority;

    private enum Authority {
        ADMIN, GUEST, USER
    }
}

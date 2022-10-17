package com.unlimint.Pojo;

import lombok.Getter;
import lombok.Setter;

public class Login {

    private @Getter
    @Setter
    String uuid;
    private @Getter
    @Setter
    String username;
    private @Getter
    @Setter
    String password;
    private @Getter
    @Setter
    String salt;
    private @Getter
    @Setter
    String md5;
    private @Getter
    @Setter
    String sha1;
    private @Getter
    @Setter
    String sha256;

}

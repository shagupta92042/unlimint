package com.unlimint.Pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class JsonFile {

    private @Getter
    @Setter
    List<Result> results = null;
    private @Getter
    @Setter
    Info info;


}

package com.unlimint.Pojo;

import lombok.Getter;
import lombok.Setter;

public class Location {

    private @Getter
    @Setter
    Street street;
    private @Getter
    @Setter
    String city;
    private @Getter
    @Setter
    String state;
    private @Getter
    @Setter
    String country;
    private @Getter
    @Setter
    String postcode;
    private @Getter
    @Setter
    Coordinates coordinates;
    private @Getter
    @Setter
    Timezone timezone;

}

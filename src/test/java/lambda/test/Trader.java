package lambda.test;

import lombok.Data;

//交易员类
@Data
public class Trader {
    private String name;
    private String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }
}

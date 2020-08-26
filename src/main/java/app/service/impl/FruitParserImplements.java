package app.service.impl;

import app.model.Fruit;
import app.service.FruitParser;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FruitParserImplements implements FruitParser {
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public Fruit parse(List<String> data) {
        return new Fruit(data.get(1), Integer.parseInt(data.get(2)),
                LocalDate.parse(data.get(3), formatter));
    }
}

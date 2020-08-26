package app.service.impl;

import app.model.Fruit;
import app.service.FruitParser;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class FruitParserImplements implements FruitParser {
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public Fruit parse(List<String> data) {
        try {
            return new Fruit(data.get(1), Integer.parseInt(data.get(2)),
                    LocalDate.parse(data.get(3), formatter));
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Wrong date in line with " + data.get(1)
                    + "," + data.get(2) + "," + data.get(3));
        }
    }
}

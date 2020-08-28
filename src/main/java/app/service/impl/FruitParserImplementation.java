package app.service.impl;

import app.model.SupplyFruit;
import app.service.FruitParser;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class FruitParserImplementation implements FruitParser {
    public static final int FIRST_ELEMENT = 1;
    public static final int SECOND_ELEMENT = 2;
    public static final int THIRD_ELEMENT = 3;

    @Override
    public SupplyFruit parse(List<String> data) {
        try {
            return new SupplyFruit(data.get(FIRST_ELEMENT),
                    Integer.parseInt(data.get(SECOND_ELEMENT)),
                    LocalDate.parse(data.get(THIRD_ELEMENT)));
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Wrong date in line with " + data.get(FIRST_ELEMENT)
                    + "," + data.get(SECOND_ELEMENT) + "," + data.get(THIRD_ELEMENT));
        }
    }
}

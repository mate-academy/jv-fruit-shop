package app.service.impl;

import app.model.SupplyFruitBatch;
import app.service.FruitParser;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class FruitParserImplementation implements FruitParser {
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int END_OF_SHELF_LIFE_INDEX = 3;

    @Override
    public SupplyFruitBatch parse(List<String> data) {
        try {
            return new SupplyFruitBatch(data.get(FRUIT_NAME_INDEX),
                    Integer.parseInt(data.get(QUANTITY_INDEX)),
                    LocalDate.parse(data.get(END_OF_SHELF_LIFE_INDEX)));
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Wrong date in line with " + data.get(FRUIT_NAME_INDEX)
                    + "," + data.get(QUANTITY_INDEX) + "," + data.get(END_OF_SHELF_LIFE_INDEX), e);
        }
    }
}

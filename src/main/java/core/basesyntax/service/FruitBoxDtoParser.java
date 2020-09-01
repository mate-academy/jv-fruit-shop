package core.basesyntax.service;

import core.basesyntax.model.FruitBox;
import java.time.LocalDate;

public class FruitBoxDtoParser {
    private static final String SPLITTER = ",";

    FruitBox parse(String line) {
        String[] data = line.split(SPLITTER);
        return new FruitBox(data[1], Integer.parseInt(data[2]), LocalDate.parse(data[3]));
    }
}

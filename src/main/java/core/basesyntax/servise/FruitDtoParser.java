package core.basesyntax.servise;

import core.basesyntax.model.FruitDto;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class FruitDtoParser {

    public FruitDto parse(String row) {
        String[] data = row.replaceAll("\"", "").split(",");
        try {
            return new FruitDto.FruitDtoBuilder()
                    .setTypeOperation(data[0])
                    .setDate(LocalDate.parse(data[3]))
                    .setName(data[1])
                    .setQuantity(Integer.parseInt(data[2]))
                    .build();
        } catch (NumberFormatException | DateTimeParseException e) {
            throw new IllegalArgumentException("Incorrect params in row!!!");
        }
    }
}

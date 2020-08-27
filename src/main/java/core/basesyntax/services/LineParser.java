package core.basesyntax.services;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class LineParser {
    private static final int CORRECT_ARG_AMOUNT = 4;
    private static final int QUANTITY_INDEX = 2;
    private static final int DATE_INDEX = 3;

    public String[] parse(String line) {
        String[] splitedLine = line.split(",");
        if (splitedLine.length != CORRECT_ARG_AMOUNT) {
            throw new RuntimeException("Wrong argument format!");
        }
        try {
            Integer.parseInt(splitedLine[QUANTITY_INDEX]);
            LocalDate.parse(splitedLine[DATE_INDEX]);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Wrong quantity format!");
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Wrong date format!");
        }
        return splitedLine;
    }
}

package core.basesyntax.services;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class LineParser {

    public String[] parse(String line) {
        String[] splitedLine = line.split(",");
        if (splitedLine.length != 4) {
            throw new RuntimeException("Wrong argument format!");
        }
        try {
            Integer.parseInt(splitedLine[2]);
            LocalDate.parse(splitedLine[3]);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Wrong quantity format!");
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Wrong date format!");
        }
        return splitedLine;
    }
}

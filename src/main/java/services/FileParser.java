package services;

import dto.PositionDto;
import java.time.LocalDate;

public class FileParser {
    private static final String SEPARATOR = ",";

    public PositionDto parse(String line) {
        String[] cortege = line.split(SEPARATOR);
        return new PositionDto(cortege[0],
                cortege[1], Integer.parseInt(cortege[2]), LocalDate.parse(cortege[3]));
    }
}

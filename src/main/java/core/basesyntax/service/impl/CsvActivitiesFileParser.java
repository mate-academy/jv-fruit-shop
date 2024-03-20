package core.basesyntax.service.impl;

import core.basesyntax.dto.ActivityDto;
import core.basesyntax.enums.ActivityType;
import core.basesyntax.exception.CsvParseException;
import core.basesyntax.service.ActivitiesFileParser;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvActivitiesFileParser implements ActivitiesFileParser {
    private static final int CODE_INDEX = 0;
    private static final int TITLE_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<ActivityDto> readFrom(String fileName) {
        try {
            return Files.lines(Path.of(fileName))
                    .skip(1)
                    .map(this::mapToDto)
                    .toList();
        } catch (IOException | NumberFormatException e) {
            throw new CsvParseException("Unexpected parsed error in " + fileName);
        }
    }

    private ActivityDto mapToDto(String line) {
        String[] columns = line.split(",");
        if (columns.length < 3) {
            throw new CsvParseException("Incorrect number of columns in CSV file");
        }
        return new ActivityDto(
                ActivityType.findByCode(columns[CODE_INDEX]),
                columns[TITLE_INDEX],
                Integer.parseInt(columns[QUANTITY_INDEX]));
    }
}

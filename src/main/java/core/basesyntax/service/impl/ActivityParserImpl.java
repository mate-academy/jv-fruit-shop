package core.basesyntax.service.impl;

import core.basesyntax.dto.ActivityDto;
import core.basesyntax.enums.ActivityType;
import core.basesyntax.exception.CsvParseException;
import core.basesyntax.service.ActivityParser;
import java.util.List;

public class ActivityParserImpl implements ActivityParser {
    private static final int HEADER_INDEX = 1;
    private static final int COLUMNS_SIZE = 3;
    private static final int CODE_INDEX = 0;
    private static final int TITLE_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String CSV_SEPARATOR = ",";

    @Override
    public List<ActivityDto> parse(List<String> activityRows) {
        return activityRows.stream()
                    .skip(HEADER_INDEX)
                    .map(this::mapToDto)
                    .toList();
    }

    private ActivityDto mapToDto(String line) {
        String[] columns = line.split(CSV_SEPARATOR);
        if (columns.length < COLUMNS_SIZE) {
            throw new CsvParseException("Incorrect number of columns in CSV file");
        }
        return new ActivityDto(
                ActivityType.findByCode(columns[CODE_INDEX]),
                columns[TITLE_INDEX],
                Integer.parseInt(columns[QUANTITY_INDEX]));
    }
}

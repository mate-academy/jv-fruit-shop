package core.basesyntax.service.impl;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.service.Parser;
import java.util.List;
import java.util.stream.Collectors;

public class ParserImpl implements Parser {
    private static final String CSV_FORMAT = "[bsrp],[\\w]+,[\\d]+";
    private static final int OPERATION_INDEX = 0;
    private static final int SKIP_LINE = 1;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitDto> parseLines(List<String> lines) {
        return lines.stream()
                .skip(SKIP_LINE)
                .map(this::getFruitDto)
                .collect(Collectors.toList());
    }

    private FruitDto getFruitDto(String line) {
        validate(line);
        String[] data = line.split(SEPARATOR);
        return new FruitDto(data[OPERATION_INDEX], data[FRUIT_INDEX],
                Integer.parseInt(data[QUANTITY_INDEX]));
    }

    private void validate(String line) {
        if (!line.matches(CSV_FORMAT)) {
            throw new RuntimeException("Data is not valid" + line);
        }
    }
}

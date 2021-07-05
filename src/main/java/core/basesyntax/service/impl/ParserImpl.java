package core.basesyntax.service.impl;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.service.Parser;

import java.util.List;
import java.util.stream.Collectors;

public class ParserImpl implements Parser {
    private static final String CSV_FORMAT = "[b,s,r,p],[a-zA-Z]+,[0-9]+";
    private static final int ZERO_INDEX = 0;
    private static final int SKIP_LINE = 1;
    private static final int FIRST_INDEX = 1;
    private static final int SECOND_INDEX = 2;
    private static final String CSV_SEPARATOR = ",";

    @Override
    public List<FruitDto> parseAndValidateLine(List<String> lines) {
        return lines.stream().skip(SKIP_LINE).filter(i -> i.matches(CSV_FORMAT)).map(l -> {
            String[] columns = l.split(CSV_SEPARATOR);
            return new FruitDto(columns[ZERO_INDEX], columns[FIRST_INDEX],
                    Integer.parseInt(columns[SECOND_INDEX]));
        }).collect(Collectors.toList());
    }
}

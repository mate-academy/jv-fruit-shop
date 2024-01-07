package core.basesyntax.service.impl;

import core.basesyntax.service.Parser;
import java.util.Arrays;
import java.util.List;

public class ParserCsvImpl implements Parser {

    @Override
    public List<String> parseLine(String line) {
        return Arrays.asList(line.split(","));
    }
}

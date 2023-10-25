package core.basesyntax.service.impl;

import core.basesyntax.service.FileParser;

public class CsvFileParserImpl implements FileParser {
    private static final String SEPARATOR = ",";
    @Override
    public String[] parse(String line) {
        return line.split(SEPARATOR);
    }
}

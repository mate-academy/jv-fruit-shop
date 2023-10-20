package core.basesyntax.service.impl;

import core.basesyntax.service.FileParser;

public class CsvFileParserImpl implements FileParser {
    @Override
    public String[] parseData(String line) {
        return line.split(",");
    }
}

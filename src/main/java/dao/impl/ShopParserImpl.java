package dao.impl;

import dao.ShopParser;

public class ShopParserImpl implements ShopParser {
    private static final String END_LINE = System.lineSeparator();

    @Override
    public String[] parse(String dataFromFile) {
        if (dataFromFile != null) {
            return dataFromFile.split(END_LINE);
        } else {
            throw new RuntimeException("Empty data!");
        }
    }
}

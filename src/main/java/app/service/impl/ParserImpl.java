package app.service.impl;

import app.dto.Transaction;
import app.service.LineValidator;
import app.service.Parser;

public class ParserImpl implements Parser {
    private static final String SEPARATOR = ",";
    private static final int TYPE = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;
    private LineValidator validator;

    public ParserImpl(LineValidator validator) {
        this.validator = validator;
    }

    @Override
    public Transaction parseLine(String line) {
        if (validator.isValid(line)) {
            String[] data = line.split(SEPARATOR);
            return new Transaction(data[TYPE], data[FRUIT], Integer.parseInt(data[QUANTITY]));
        }
        throw new RuntimeException("Not correct line : " + line);
    }
}

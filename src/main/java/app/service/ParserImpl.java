package app.service;

import static app.constants.Constants.FRUIT;
import static app.constants.Constants.QUANTITY;
import static app.constants.Constants.SEPARATOR;
import static app.constants.Constants.TYPE;

import app.dto.Transaction;

public class ParserImpl implements Parser {

    @Override
    public Transaction parseLine(String line) {
        String[] data = line.split(SEPARATOR);
        return new Transaction(data[TYPE], data[FRUIT], Integer.parseInt(data[QUANTITY]));
    }
}

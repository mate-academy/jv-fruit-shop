package service;

import dto.ShopOperation;

public class ParserImpl implements Parser {
    @Override
    public ShopOperation parseLine(String line) {
        String[] splittedLine = line.split(",");
        if (splittedLine.length != 3) {
            throw new RuntimeException("wrong input line");
        }
        String operation = splittedLine[0];
        String fruit = splittedLine[1];
        int amount;
        try {
            amount = Integer.parseInt(splittedLine[2]);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Wrong fruit amount");
        }
        if (amount < 0) {
            throw new RuntimeException("Wrong fruit amount");
        }
        return new ShopOperation(operation, fruit, amount);
    }
}

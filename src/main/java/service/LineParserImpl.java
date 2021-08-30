package service;

import shop.FruitShopOperation;

public class LineParserImpl implements LineParser {
    private int amount;
    private String [] arrayLines;
    private String operation;
    private String fruit;

    @Override
    public FruitShopOperation parseLine(String inputLine) {
        arrayLines = inputLine.split(",");
        operation = arrayLines[0];
        fruit = arrayLines[1];
        amount = Integer.parseInt(arrayLines[2]);
        return new FruitShopOperation(operation, fruit, amount);
    }
}

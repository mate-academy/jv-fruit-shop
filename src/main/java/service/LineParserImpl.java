package service;

import shop.Fruit;
import shop.FruitShopOperation;

public class LineParserImpl implements LineParser {

    @Override
    public FruitShopOperation parseLine(String inputLine) {
        String[] arrayLines = inputLine.split(",");
        String operation = arrayLines[0];
        Fruit fruit = new Fruit(arrayLines[1]);
        int amount = Integer.parseInt(arrayLines[2]);
        return new FruitShopOperation(operation, fruit, amount);
    }
}

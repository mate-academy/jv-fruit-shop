package service.impl;

import java.util.List;
import model.TransactionDto;
import service.Parser;

public class ParserImpl implements Parser {
    private static final int INDEX_OF_TYPE = 0;
    private static final int INDEX_OF_FRUIT_NAME = 1;
    private static final int INDEX_OF_QUANTITY = 2;

    @Override
    public TransactionDto parseLine(String line) {
        String[] arrayStringLine = line.split(",");
        String fruitType = arrayStringLine[INDEX_OF_TYPE];
        String fruitName = arrayStringLine[INDEX_OF_FRUIT_NAME];
        int quantity = Integer.parseInt(arrayStringLine[INDEX_OF_QUANTITY]);
        return new TransactionDto(fruitType, fruitName, quantity);
    }

    @Override
    public List<FruitServiceImpl.Transaction> parse(List<String> lines) {
        return null;
    }
}

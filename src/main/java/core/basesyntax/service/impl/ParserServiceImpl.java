package core.basesyntax.service.impl;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final int INDEX_OF_TYPE = 0;
    private static final int INDEX_OF_FRUIT_NAME = 1;
    private static final int INDEX_OF_QUANTITY = 2;

    @Override
    public TransactionDto parse(String line) {
        String[] arrayLine = line.split(",");
        String abbreviationActivityType = arrayLine[INDEX_OF_TYPE];
        String fruitName = arrayLine[INDEX_OF_FRUIT_NAME];
        int quantity = Integer.parseInt(arrayLine[INDEX_OF_QUANTITY]);
        return new TransactionDto(abbreviationActivityType, fruitName, quantity);
    }

    public List<TransactionDto> parseLine(List<String> data) {
        ParserService parserService = new ParserServiceImpl();
        List<TransactionDto> transactionDto = new ArrayList<>();
        for (int i = 1; i < data.size(); i++) {
            transactionDto.add(parserService.parse(data.get(i)));
        }
        return transactionDto;
    }
}

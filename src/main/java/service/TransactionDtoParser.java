package service;

import exception.IncorrectFruitTypeException;
import java.util.ArrayList;
import java.util.List;
import model.Fruit;
import model.OperationType;

public class TransactionDtoParser {
    private static final String SEPARATING_ELEMENT = ",";
    private static final int INDEX_OF_OPERATION_TYPE = 0;
    private static final int INDEX_OF_FRUIT_TYPE = 1;
    private static final int INDEX_OF_QUANTITY = 2;
    private static final String INTEGER_MATCH = "[0-9]+";
    private static final String FRUIT_MATCH = "[a-z]+";
    private static final String FIRST_LINE = "type,fruit,quantity";

    public List<TransactionDto> parser(List<String> fileContent) {
        List<TransactionDto> transactionList = new ArrayList<>();
        for (String line : fileContent) {
            if (line.equals(FIRST_LINE)) {
                continue;
            }
            String[] transactions = line.split(SEPARATING_ELEMENT);
            TransactionDto transactionDto = getValidTransaction(transactions);
            transactionList.add(transactionDto);
        }
        return transactionList;
    }

    private TransactionDto getValidTransaction(String[] transactions) {
        if (!transactions[INDEX_OF_FRUIT_TYPE].matches(FRUIT_MATCH)) {
            throw new IncorrectFruitTypeException("Fruit type should match "
                    + FRUIT_MATCH + " but was - " + transactions[INDEX_OF_FRUIT_TYPE]);
        }
        if (!transactions[INDEX_OF_QUANTITY].matches(INTEGER_MATCH)) {
            throw new IncorrectFruitTypeException("Quantity value should match "
                    + INTEGER_MATCH + " but was - " + transactions[INDEX_OF_QUANTITY]);
        }
        int quantity = Integer.parseInt(transactions[INDEX_OF_QUANTITY]);
        if (quantity < 0) {
            throw new IncorrectFruitTypeException("Input value cannot be less than 0");
        }
        return new TransactionDto(OperationType.getOperationType(
                transactions[INDEX_OF_OPERATION_TYPE]),
                new Fruit(transactions[INDEX_OF_FRUIT_TYPE]),
                quantity);
    }
}

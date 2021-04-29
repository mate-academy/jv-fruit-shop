package service;

import exception.IncorrectInputValueException;
import java.util.ArrayList;
import java.util.List;
import model.Fruit;
import model.OperationType;

public class TransactionDto {
    private static final String SEPARATING_ELEMENT = ",";
    private static final int INDEX_OF_OPERATION_TYPE = 0;
    private static final int INDEX_OF_FRUIT_TYPE = 1;
    private static final int INDEX_OF_QUANTITY = 2;
    private static final String INTEGER_MATCH = "[0-9]+";
    private static final String FRUIT_MATCH = "[a-z]+";
    private static final String FIRST_LINE = "type,fruit,quantity";
    private OperationType type;
    private Fruit fruit;
    private Integer quantity;

    public TransactionDto() {
    }

    public TransactionDto(OperationType type, Fruit fruit, Integer quantity) {
        this.type = type;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public OperationType getType() {
        return type;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public List<TransactionDto> parser(List<String> fileContent) {
        List<TransactionDto> transactionList = new ArrayList<>();
        for (String line : fileContent) {
            if (line.equals(FIRST_LINE)) {
                continue;
            }
            String[] information = line.split(SEPARATING_ELEMENT);
            TransactionDto transactionDto = transactionValidator(information);
            transactionList.add(transactionDto);
        }
        return transactionList;
    }

    private TransactionDto transactionValidator(String[] information) {
        if (!information[INDEX_OF_FRUIT_TYPE].matches(FRUIT_MATCH)) {
            throw new IncorrectInputValueException("Fruit type should match "
            + FRUIT_MATCH + " but was - " + information[INDEX_OF_FRUIT_TYPE]);
        }
        if (!information[INDEX_OF_QUANTITY].matches(INTEGER_MATCH)) {
            throw new IncorrectInputValueException("Quantity value should match "
            + INTEGER_MATCH + " but was - " + information[INDEX_OF_QUANTITY]);
        }
        int quantity = Integer.parseInt(information[INDEX_OF_QUANTITY]);
        if (quantity < 0) {
            throw new IncorrectInputValueException("Input value cannot be less than 0");
        }
        return new TransactionDto(OperationType.getOperationType(
                information[INDEX_OF_OPERATION_TYPE]),
                new Fruit(information[INDEX_OF_FRUIT_TYPE]),
                quantity);
    }
}

package core.basesyntax.service.parser.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.operationhandler.Operation;
import core.basesyntax.service.parser.ParserService;
import core.basesyntax.service.validator.Validator;
import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final int DEFAULT_OPERATION_TYPE_INDEX = 0;
    private static final int DEFAULT_FRUIT_NAME_INDEX = 1;
    private static final int DEFAULT_QUANTITY_INDEX = 2;
    private static final String DEFAULT_STRING_SEPARATOR = ",";
    private Validator validator;

    public ParserServiceImpl(Validator validator) {
        this.validator = validator;
    }

    @Override
    public List<Transaction> parse(List<String> dataFromFile) {
        validator.isValid(dataFromFile);
        List<Transaction> transactionList = new ArrayList<>();
        String[] currentLineArray;
        Operation currentOperation;
        int currentQuantity;
        Fruit currentFruit;
        for (String currentLine : dataFromFile) {
            if (currentLine.equals("type,fruit,quantity")) {
                continue;
            }
            currentLineArray = currentLine.split(DEFAULT_STRING_SEPARATOR);
            currentOperation = Operation.get(currentLineArray[DEFAULT_OPERATION_TYPE_INDEX]);
            currentFruit = new Fruit(currentLineArray[DEFAULT_FRUIT_NAME_INDEX]);
            currentQuantity = Integer.parseInt(currentLineArray[DEFAULT_QUANTITY_INDEX]);
            transactionList.add(new Transaction(currentOperation, currentFruit, currentQuantity));
        }
        return transactionList;
    }
}

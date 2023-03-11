package core.basesyntax.service.parser.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.operationhandler.Operation;
import core.basesyntax.service.parser.ParserService;
import core.basesyntax.service.validator.Validator;
import java.util.ArrayList;
import java.util.List;

public class CsvParserService implements ParserService {
    private static final int DEFAULT_OPERATION_TYPE_INDEX = 0;
    private static final int DEFAULT_FRUIT_NAME_INDEX = 1;
    private static final int DEFAULT_QUANTITY_INDEX = 2;

    private Validator validator;

    public CsvParserService(Validator validator) {
        this.validator = validator;
    }

    @Override
    public List<Transaction> parse(List<String> dataFromFile) {
        validator.isValid(dataFromFile);
        dataFromFile.remove(0);
        List<Transaction> transactionList = new ArrayList<>();
        String[] currentLineArray;
        Operation currentOperation;
        int currentQuantity;
        Fruit currentFruit;
        for (String currentLine : dataFromFile) {
            currentLineArray = currentLine.split(",");
            currentOperation = Operation.get(currentLineArray[DEFAULT_OPERATION_TYPE_INDEX]);
            currentFruit = new Fruit(currentLineArray[DEFAULT_FRUIT_NAME_INDEX]);
            currentQuantity = Integer.parseInt(currentLineArray[DEFAULT_QUANTITY_INDEX]);
            transactionList.add(new Transaction(currentOperation, currentFruit, currentQuantity));
        }
        return transactionList;
    }
}

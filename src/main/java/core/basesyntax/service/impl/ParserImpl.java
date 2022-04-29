package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.Parser;
import core.basesyntax.validation.OperationValidator;

public class ParserImpl implements Parser {
    private static final int INDEX_FRUIT_AMOUNT = 2;
    private static final int INDEX_FRUIT_TYPE = 1;
    private static final int INDEX_OPERATION_TYPE = 0;

    private OperationValidator operationValidator;

    public ParserImpl(OperationValidator operationValidator) {
        this.operationValidator = operationValidator;
    }

    @Override
    public TransactionDto parseLine(String line) {
        String[] splittedLine = line.split(",");
        operationValidator.isOperationValid(splittedLine);
        String fruitName = splittedLine[INDEX_FRUIT_TYPE];
        Operation operationType = Operation
                .getOperation(splittedLine[INDEX_OPERATION_TYPE]);
        int amountOfFruits = Integer.parseInt(splittedLine[INDEX_FRUIT_AMOUNT]);
        return new TransactionDto(operationType, fruitName, amountOfFruits);
    }
}

package core.basesyntax.service;

import core.basesyntax.dto.Fruit;
import core.basesyntax.dto.Operation;
import core.basesyntax.exceptions.IllegalDataException;

import java.util.List;
import java.util.stream.Collectors;

public class OperationParser implements Parser {
    private static final int TYPE_FIELD = 0;
    private static final int FRUIT_FIELD = 1;
    private static final int QUANTITY_FIELD = 2;
    private static final int SIZE = 3;
    private static final String COMA = ",";
    private static final String BALANCE_CHARACTER = "b";
    private static final String SUPPLY_CHARACTER = "s";
    private static final String PURCHASE_CHARACTER = "p";
    private static final String RETURN_CHARACTER = "r";

    @Override
    public List<Operation> parseOperationsToList(List<String> list) {
       return list.stream().map(this::parseDataToOperation).collect(Collectors.toList());
    }

    @Override
    public Operation parseDataToOperation(String line) {
        String[] operationFields = line.split(COMA);
        if (operationFields.length != SIZE) {
            throw new IllegalDataException("Can't parse this line, resulting array length is: "
                    + operationFields.length + " expected length: " + SIZE);
        }
        Operation.OperationType type;
        switch (operationFields[TYPE_FIELD]) {
            case BALANCE_CHARACTER :
                type = Operation.OperationType.BALANCE;
                break;
            case SUPPLY_CHARACTER :
                type = Operation.OperationType.SUPPLY;
                break;
            case PURCHASE_CHARACTER :
                type = Operation.OperationType.PURCHASE;
                break;
            case RETURN_CHARACTER :
                type = Operation.OperationType.RETURN;
                break;
            default :
                throw new IllegalArgumentException("This operation type is not valid: "
                        + operationFields[TYPE_FIELD]);
        }
        int quantity = Integer.parseInt(operationFields[QUANTITY_FIELD]);
        Fruit fruit = new Fruit(operationFields[FRUIT_FIELD]);
        return new Operation(type, fruit, quantity);
    }
}

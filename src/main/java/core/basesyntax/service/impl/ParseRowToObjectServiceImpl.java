package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitOperationDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ParseRowToObjectService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ParseRowToObjectServiceImpl implements ParseRowToObjectService {
    private static final String SEPARATOR = ",";
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;
    private static final int LENGTH_ONE_LINE = 3;
    private final FruitOperationDao fruitOperationDao;

    public ParseRowToObjectServiceImpl(FruitOperationDao fruitOperationDao) {
        this.fruitOperationDao = fruitOperationDao;
    }

    @Override
    public List<FruitTransaction> parseRowToObjects() {
        List<String> lines = fruitOperationDao.readFile();
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : lines) {
            String[] fields = line.split(SEPARATOR);
            if (fields.length < LENGTH_ONE_LINE) {
                continue;
            }
            Operation operation = parseOperation(fields[OPERATION]);
            String fruit = fields[FRUIT].trim();
            BigDecimal quantity = parseQuantity(fields[QUANTITY]);
            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }

    private Operation parseOperation(String operationField) {
        try {
            return Operation.fromCode(operationField.trim());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid operation type.");
        }
    }

    private BigDecimal parseQuantity(String quantityField) {
        try {
            return new BigDecimal(quantityField.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid quantity value.");
        }
    }
}

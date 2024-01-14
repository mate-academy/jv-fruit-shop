package core.basesyntax.service.impl;

import core.basesyntax.dao.ArticleDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;

public class FruitTransactionServiceImpl implements TransactionService {
    private static final String LINE_SEPARATOR = ",";
    private static final int NUMBER_OF_FIELDS = 3;
    private static final int TRANSACTION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private ArticleDao fruitTransactionDao;

    public FruitTransactionServiceImpl(ArticleDao fruitTransactionDao) {
        this.fruitTransactionDao = fruitTransactionDao;
    }

    @Override
    public FruitTransaction createTransaction(String line) {
        FruitTransaction transaction = new FruitTransaction();
        String[] fields = line.split(LINE_SEPARATOR);
        if (fields.length != NUMBER_OF_FIELDS) {
            throw new RuntimeException("Wrong format in line: '" + line + "'\nShould be: "
                    + "'transaction_type,fruit,quantity'");
        }
        String fruit = validateFruitField(fields[FRUIT_INDEX], line);
        transaction.setFruit(fruit);
        int quantity = validateQuantityField(fields[QUANTITY_INDEX], line);
        transaction.setQuantity(quantity);
        FruitTransaction.Operation operation
                = validateOperationField(fields[TRANSACTION_INDEX], line);
        transaction.setOperation(operation);
        return transaction;
    }

    private String validateFruitField(String fruitField, String line) {
        if (fruitField == null && fruitField.length() == 0) {
            throw new RuntimeException("Wrong format of fruit field in line: '" + line
                    + "'\nShould be: " + "'transaction_type,fruit,quantity'");
        }
        if (fruitTransactionDao.getQuantity(fruitField) == null) {
            throw new RuntimeException("frit '" + fruitField
                    + "' doesn't exist in database or wrong fruit name in line: '" + line + "'");
        }
        return fruitField;
    }

    private int validateQuantityField(String quantityField, String line) {
        try {
            int quantity = Integer.parseInt(quantityField);
            if (quantity < 0) {
                throw new RuntimeException("Quantity can't be less than zero");
            }
            return quantity;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Wrong format of quantity field in line: '" + line
                    + "'\n The field should be a number");

        }

    }

    private FruitTransaction.Operation validateOperationField(String operationField, String line) {
        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            if (operation.getCode().equals(operationField)) {
                return operation;
            }
        }
        throw new RuntimeException("Incorrect transaction index in line: '" + line + "'");
    }

}

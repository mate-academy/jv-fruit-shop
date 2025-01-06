package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.DataConverter;

public class DataConverterImpl implements DataConverter {
    static final int TRANSACTIONS_START_INDEX = 1;
    static final int OPERATION_INDEX = 0;
    static final int FRUIT_INDEX = 1;
    static final int QUANTITY_INDEX = 2;
    static final String BALANCE_ABBR = "b";
    static final String SUPPLY_ABBR = "s";
    static final String PURCHASE_ABBR = "p";
    static final String RETURN_ABBR = "r";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> readerOutput) {
        if (readerOutput == null) {
            return new ArrayList<>();
        }
        List<FruitTransaction> converterOutput = new ArrayList<>();
        for (int i = TRANSACTIONS_START_INDEX; i < readerOutput.size(); i++) {
            String[] parts = readerOutput.get(i).split(",");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Incorrect format of data");
            }
            FruitTransaction.Operation transactionOperation = getOperation(parts);
            converterOutput.add(new FruitTransaction(
                    transactionOperation,
                    parts[FRUIT_INDEX].trim(),
                    Integer.parseInt(parts[QUANTITY_INDEX].trim()
                    )));
        }
        return converterOutput;
    }

    private static FruitTransaction.Operation getOperation(String[] parts) {
        String transactionString = parts[OPERATION_INDEX].trim();
        FruitTransaction.Operation transactionOperation = null;
        switch (transactionString) {
            case BALANCE_ABBR -> transactionOperation = FruitTransaction.Operation.BALANCE;
            case SUPPLY_ABBR -> transactionOperation = FruitTransaction.Operation.SUPPLY;
            case PURCHASE_ABBR -> transactionOperation = FruitTransaction.Operation.PURCHASE;
            case RETURN_ABBR -> transactionOperation = FruitTransaction.Operation.RETURN;
            default -> throw new IllegalArgumentException("Invalid operation: "
                    + transactionString);
        }
        return transactionOperation;
    }
}

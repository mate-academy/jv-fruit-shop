package core.basesyntax.service.impl;

import core.basesyntax.Main;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ConverterDataToFruitTransactionService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ConverterDataToFruitTransactionServiceImpl
        implements ConverterDataToFruitTransactionService {

    public static final String COMA_DELIMITER = ",";
    public static final int OPERATION_CODE_INDEX = 0;
    public static final int QUANTITY_INDEX = 2;
    public static final int FRUIT_NAME_INDEX = 1;

    @Override
    public List<FruitTransaction> convertToFruitTransaction(List<String> dataStringList) {
        List<FruitTransaction> transactionList = new ArrayList<>();

        for (String stringTransaction : dataStringList) {
            if (stringTransaction.equals(Main.DATA_FILE_TITLE)) {
                continue;
            }

            String[] transactionArray = stringTransaction.split(COMA_DELIMITER);
            Operation operation = getOperation(transactionArray[OPERATION_CODE_INDEX]);

            int quantity = Integer.parseInt(transactionArray[QUANTITY_INDEX]);

            FruitTransaction transaction = new FruitTransaction();
            transaction.setOperation(operation);
            transaction.setFruitName(transactionArray[FRUIT_NAME_INDEX]);
            transaction.setQuantity(quantity);

            transactionList.add(transaction);
        }

        return transactionList;
    }

    private Operation getOperation(String code) {
        Optional<Operation> operation = Arrays.stream(Operation.values())
                .filter(o -> o.getCode().equals(code))
                .findFirst();

        return operation.orElseThrow(() -> new RuntimeException("Wrong operation code - " + code));
    }
}

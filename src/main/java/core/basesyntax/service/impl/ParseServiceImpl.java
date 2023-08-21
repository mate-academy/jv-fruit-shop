package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ParseService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ParseServiceImpl
        implements ParseService {
    public static final String COMA_DELIMITER = ",";
    public static final int OPERATION_CODE_INDEX = 0;
    public static final int QUANTITY_INDEX = 2;
    public static final int FRUIT_NAME_INDEX = 1;

    @Override
    public List<FruitTransaction> parseTransaction(List<String> dataStringList) {
        List<FruitTransaction> transactionList = new ArrayList<>();

        for (int i = 1; i < dataStringList.size(); i++) {
            String[] transactionArray = dataStringList.get(i).split(COMA_DELIMITER);
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

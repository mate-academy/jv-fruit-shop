package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParserService;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionParserServiceImpl implements FruitTransactionParserService {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SPLITTER = ",";

    /**
     * better run through each value of your enum and search through its operation field
     * you can use Stream API
     * @param list
     * @return
     */
    @Override
    public List<FruitTransaction> parse(List<String> list) {
        List<FruitTransaction> parsedTransaction = new ArrayList<>();

        for (int i = 1; i < list.size(); i++) {
            String[] splitData = list.get(i).split(SPLITTER);
            FruitTransaction.Operation operation = getOperation(splitData[OPERATION_TYPE_INDEX]);
            String fruitName = splitData[FRUIT_NAME_INDEX];
            int quantity = Integer.parseInt(splitData[QUANTITY_INDEX]);
            parsedTransaction.add(new FruitTransaction(operation, fruitName, quantity));
        }
        return parsedTransaction;
    }

    /**
     * better remove and do it through Stream API inside upper method
     * @param operationLetter
     * @return
     */
    private FruitTransaction.Operation getOperation(String operationLetter) {
        switch (operationLetter) {
            case "b":
                return FruitTransaction.Operation.BALANCE;
            case "r":
                return FruitTransaction.Operation.RETURN;
            case "p":
                return FruitTransaction.Operation.PURCHASE;
            case "s":
                return FruitTransaction.Operation.SUPPLY;
            default:
                throw new RuntimeException("Can't find letter " + operationLetter + " in file");
        }
    }
}

package core.basesyntax.service.serviceimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitDataParserService;
import java.util.ArrayList;
import java.util.List;

public class FruitDataParserImpl implements FruitDataParserService {

    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SPLITTER = ",";

    @Override
    public List<FruitTransaction> parse(List<String> list) {
        List<FruitTransaction> parsedFruits = new ArrayList<>();

        for (String s : list) {
            String[] splitted = s.split(SPLITTER);
            FruitTransaction.Operation op = getOperation(splitted[OPERATION_TYPE_INDEX]);
            String fruitName = splitted[FRUIT_NAME_INDEX];
            int quantity = Integer.parseInt(splitted[QUANTITY_INDEX]);
            parsedFruits.add(new FruitTransaction(op, fruitName, quantity));
        }
        return parsedFruits;
    }

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

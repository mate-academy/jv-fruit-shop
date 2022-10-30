package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FruitTransactionData;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionDataImpl implements FruitTransactionData {
    private static final String STRING_SEPARATOR = ",";

    @Override
    public List<FruitTransaction> createFruitTransactionEqualFile(List<String> listReadFile) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        listReadFile.stream()
                .skip(1)
                .map(String::trim)
                .map(i -> i.split(STRING_SEPARATOR))
                .forEach(i -> fruitTransactions
                        .add(new FruitTransaction(Operation
                                .getFromEqualString(i[0]), i[1], Integer.parseInt(i[2]))));
        return fruitTransactions;
    }
}

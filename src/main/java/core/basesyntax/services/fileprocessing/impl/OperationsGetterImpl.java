package core.basesyntax.services.fileprocessing.impl;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.services.fileprocessing.OperationsGetter;
import java.util.ArrayList;
import java.util.List;

public class OperationsGetterImpl implements OperationsGetter {
    private static final String STRING_SPLITTER = ",";
    private static final String SKIP_LINE_IF_CONTAINS_TYPE = "type";

    @Override
    public List<FruitTransaction> getOperationsData(List<String> rawData) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        List<String[]> dataDivided = rawData.stream().map(string -> string.split(STRING_SPLITTER))
                .filter(strings -> !strings[0].equals(SKIP_LINE_IF_CONTAINS_TYPE)).toList();
        for (String[] strings : dataDivided) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(fruitTransaction.getOperationFromEnum(strings[0]));
            fruitTransaction.setFruit(strings[1]);
            fruitTransaction.setQuantity(Integer.parseInt(strings[2]));
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}

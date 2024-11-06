package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (String item: inputReport) {
            String[] arrayFromItem = item.replaceAll(" ", "").split(",");
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(FruitTransaction.Operation.fromCode(arrayFromItem[0]));
            fruitTransaction.setFruit(arrayFromItem[1]);
            fruitTransaction.setQuantity(Integer.parseInt(arrayFromItem[2]));
            fruitTransactionList.add(fruitTransaction);
        }
        return fruitTransactionList;
    }
}

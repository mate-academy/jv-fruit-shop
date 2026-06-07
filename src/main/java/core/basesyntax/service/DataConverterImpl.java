package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        final List<FruitTransaction> fruitTransactionList = new ArrayList<>();

        for (int i = 1; i < inputReport.size(); i++) {
            String[] splitLine = inputReport.get(i).split(",");

            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(splitLine[0]);
            fruitTransaction.setFruit(splitLine[1]);
            fruitTransaction.setQuantity(Integer.parseInt(splitLine[2]));

            fruitTransactionList.add(fruitTransaction);
        }
        return fruitTransactionList;
    }
}

package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import core.basesyntax.service.DataConverter;

import java.util.ArrayList;
import java.util.List;

import static core.basesyntax.FruitTransaction.convertFromCode;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (String line : inputReport) {
            String[] type = line.split(",");
            FruitTransaction.Operation operation = convertFromCode(type[0]);
            String product = type[1];
            int numberOfProduct = Integer.parseInt(type[2]);

            FruitTransaction fruitTransaction = new FruitTransaction(operation, product, numberOfProduct);
            fruitTransactionList.add(fruitTransaction);
        }
        return fruitTransactionList;
    }

}

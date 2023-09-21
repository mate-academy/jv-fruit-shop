package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private List<FruitTransaction> listOfFruitTrsacion = new ArrayList<>();

    @Override
    public List<FruitTransaction> parseTransaction(List<String[]> strings) {

        for (String[] el : strings) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            for (int i = 0; i < el.length; i += 3) {
                fruitTransaction.setOperation(el[i]);
                fruitTransaction.setFruit(el[i + 1]);
                fruitTransaction.setQuantity(Integer.parseInt(el[i + 2]));

            }
            listOfFruitTrsacion.add(fruitTransaction);

        }
        return listOfFruitTrsacion;
    }
}

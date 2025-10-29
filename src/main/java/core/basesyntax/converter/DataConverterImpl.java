package core.basesyntax.converter;

import core.basesyntax.db.Operation;
import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    @Override
    public List<FruitTransaction> convert(List<String> lines) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();

        for (int i = 1; i < lines.size(); i++) {
            String[] oper = lines.get(i).split(",");

            Operation operation1 = Operation.formCode(oper[0]);
            String fruit = oper[1];
            int quantity = Integer.parseInt(oper[2]);

            fruitTransactionList.add(new FruitTransaction(operation1, fruit, quantity));
        }
        return fruitTransactionList;
    }
}

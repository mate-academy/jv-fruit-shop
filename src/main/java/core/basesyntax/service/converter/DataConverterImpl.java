package core.basesyntax.service.converter;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> records) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = 1; i < records.size(); i++) {
            String[] split = records.get(i).split(",");
            FruitTransaction.Operation operation = Arrays.stream(FruitTransaction.Operation
                            .values())
                    .filter(e -> e.getCode().equals(split[0]))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Can not find Operation Enum"));
            FruitTransaction transaction = new FruitTransaction();
            transaction.setFruit(split[1]);
            transaction.setOperation(operation);
            transaction.setQuantity(Integer.parseInt(split[2]));
            fruitTransactions.add(transaction);
        }
        return fruitTransactions;
    }
}

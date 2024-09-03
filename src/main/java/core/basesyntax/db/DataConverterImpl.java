package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        return inputReport.stream()
                .map(a -> a.replaceAll(" ",""))
                .map(a -> a.split(","))
                .map(el -> new FruitTransaction()
                        .setOperation(el[0])
                        .setFruit(el[1])
                        .setQuantity((int)Integer.valueOf(el[2])))
                .collect(Collectors.toList());
    }
}

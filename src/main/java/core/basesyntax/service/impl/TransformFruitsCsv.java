package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.model.Product;
import core.basesyntax.model.ProductType;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.TransformDataForDB;
import java.util.List;
import java.util.stream.Collectors;

public class TransformFruitsCsv implements TransformDataForDB {
    private static final String SEPARATOR = ",";
    private static final ProductType PRODUCT_TYPE = ProductType.FRUITS;

    @Override
    public List<Transaction> getTransactions(List<String> strings) {
        return strings.stream()
                .map(s -> {
                    String[] as = s.split(SEPARATOR);
                    return new Transaction(Operation.of(as[0]),
                                    new Product(as[1], PRODUCT_TYPE),
                                    Integer.parseInt(as[2])); })
                .collect(Collectors.toList());
    }
}

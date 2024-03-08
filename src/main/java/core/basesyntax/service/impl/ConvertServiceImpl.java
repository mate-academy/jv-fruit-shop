package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ConvertService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConvertServiceImpl implements ConvertService {
    private static final String COMMA = ",";
    private static final int INDEX_OF_TITLE = 0;
    private static final int INDEX_OF_OPERATIONS = 0;
    private static final int INDEX_OF_PRODUCT_AMOUNT = 2;

    @Override
    public List<Fruit> convert(List<String> data) {
        data.remove(INDEX_OF_TITLE);
        Set<String> products = getProducts(data);
        List<Fruit> fruits = new ArrayList<>();
        for (String product : products) {
            Map<Operation, Integer> operations = new HashMap<>();
            for (String line : data) {
                if (line.contains(product)) {
                    String[] split = line.split(COMMA);
                    Operation operation = Operation.fromCode(split[INDEX_OF_OPERATIONS]);
                    int amount = Integer.parseInt(split[INDEX_OF_PRODUCT_AMOUNT]);
                    operations.merge(operation, amount,
                            Integer::sum);
                }
                fruits.add(new Fruit(product, operations));
            }
        }
        return fruits;
    }

    private Set<String> getProducts(List<String> sourceData) {
        Set<String> products = new HashSet<>();
        int indexOfProductName = 1;
        for (String line : sourceData) {
            String[] elements = getSplitData(line);
            String productName = elements[indexOfProductName];
            products.add(productName);
        }
        return products;
    }

    private String[] getSplitData(String line) {
        return line.split(COMMA);
    }
}

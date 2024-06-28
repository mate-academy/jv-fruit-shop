package dev.transaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataConverterImpl implements DataConverter {
    private static final String DEFAULT_DELIMETER = ",";
    private static final String TYPE_MAPPER = "type";
    private static final String FRUIT_MAPPER = "fruit";
    private static final String QUANTITY_MAPPER = "quantity";
    private final Map<String, Integer> orderConvertMap;

    public DataConverterImpl() {
        orderConvertMap = new HashMap<>();
    }

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        setIndexes(lines.get(0));
        return parseFruitTransactions(lines.subList(1, lines.size()));
    }

    private void setIndexes(String pattern) {
        String[] types = pattern.split(DEFAULT_DELIMETER);
        for (int i = 0; i < types.length; i++) {
            orderConvertMap.put(types[i], i);
        }
    }

    private List<FruitTransaction> parseFruitTransactions(List<String> strings) {
        return strings.stream()
                .map(this::toFruitTransaction)
                .toList();
    }

    private FruitTransaction toFruitTransaction(String s) {
        String[] params = s.split(DEFAULT_DELIMETER);
        return new FruitTransaction(
                toFruit(params),
                toOperation(params),
                toQuantity(params)
        );
    }

    private Integer toQuantity(String[] params) {
        return Integer.parseInt(
          params[orderConvertMap.get(QUANTITY_MAPPER)]
        );
    }

    private String toFruit(String[] params) {
        return params[orderConvertMap.get(FRUIT_MAPPER)];
    }

    private FruitTransaction.Operation toOperation(String[] params) {
        return FruitTransaction.Operation
                .getOperation(params[orderConvertMap.get(TYPE_MAPPER)]);
    }
}

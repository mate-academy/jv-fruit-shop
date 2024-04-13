package core.basesyntax.servise.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.servise.FruitService;
import core.basesyntax.servise.FruitTransaction;
import core.basesyntax.servise.strategy.OperationStrategies;
import java.util.List;
import java.util.stream.Collectors;

public class FruitServiceImpl implements FruitService {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String TITLE = "fruit,quantity" + LINE_SEPARATOR;
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final OperationStrategies strategy;

    public FruitServiceImpl(OperationStrategies strategy) {
        this.strategy = strategy;
    }

    @Override
    public void processingData(List<String> inputData) {
        inputData.stream()
                .skip(1)
                .map(s -> s.split(","))
                .map(a -> new FruitTransaction(
                        a[TYPE_INDEX],
                        a[FRUIT_INDEX],
                        Integer.parseInt(a[QUANTITY_INDEX])))
                .forEach(f -> strategy.getOperationHandler(f).calculation());
    }

    @Override
    public String generateReport() {
        return Storage.balance.entrySet().stream()
                .map(e -> new StringBuilder()
                        .append(e.getKey())
                        .append(",")
                        .append(e.getValue()))
                .map(StringBuilder::toString)
                .collect(Collectors.joining(LINE_SEPARATOR, TITLE,""));
    }
}

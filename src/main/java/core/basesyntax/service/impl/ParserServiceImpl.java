package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {

    public ParserServiceImpl() {
    }

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        lines.remove(0);
        return lines.stream()
                .map(this::createTransactionFromLine)
                .collect(Collectors.toList());
    }

    private FruitTransaction createTransactionFromLine(String line) {
        String[] data = line.split(",");
        return new FruitTransaction(getOperationByValue(data[0]),
                new Fruit(data[1]), Integer.parseInt(data[2]));
    }

    private FruitTransaction.Operation getOperationByValue(String value) {
        return Arrays.stream(FruitTransaction.Operation.values())
                .filter(o -> o.getOperation().equals(value))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Unsupported operation: " + value));
    }
}

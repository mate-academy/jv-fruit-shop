package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class LineSeparatorImpl implements LineSeparator {
    @Override
    public List<FruitTransaction> separator(List<String> lines) {
        return lines.stream()
                .map(line -> line.split(","))
                .filter(nullName -> nullName[1].length() >= 1 && nullName[0].length() >= 1)
                .map(line -> new FruitTransaction(FruitTransaction
                        .Operation.fromOperation(line[0]), line[1], Integer.parseInt(line[2])))
                .collect(Collectors.toList());
    }
}

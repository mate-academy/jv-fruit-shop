package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;

import java.util.List;
import java.util.stream.Collectors;

public class ParseServiceImpl implements ParserService {
    @Override
    public List<FruitTransaction> parse(List<String> strings) {
        return strings.stream()
                .map(line -> {
                    String[] parts = line.split(",");
                    return new FruitTransaction(
                            FruitTransaction.Operation.valueOf(parts[0]),
                            parts[1],
                            Integer.parseInt(parts[2]));
                })
                .collect(Collectors.toList());
    }
}

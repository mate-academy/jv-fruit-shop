package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvParserService;
import java.util.List;
import java.util.stream.Collectors;

public class CsvParserServiceImpl implements CsvParserService {
    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        return lines.stream()
                .skip(1) // Skip header
                .map(line -> line.split(","))
                .map(parts -> new FruitTransaction(
                        FruitTransaction.Operation.fromCode(parts[0]),
                        parts[1],
                        Integer.parseInt(parts[2])
                ))
                .collect(Collectors.toList());
    }
}

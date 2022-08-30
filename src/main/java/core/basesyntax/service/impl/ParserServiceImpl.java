package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ParserService;

import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    @Override
    public List<Transaction> parse(List<String> lines) {
        return lines.stream()
                .skip(1)
                .map(this::getFromCsvRow)
                .collect(Collectors.toList());
    }

    private Transaction getFromCsvRow(String line) {
        String[] fields = line.split(",");
        return new Transaction(fields[0], new Fruit(fields[1]), Integer.parseInt(fields[2]));
    }
}


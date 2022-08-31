package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.ParserService;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private static final String REGEX = ",";

    @Override
    public List<Transaction> parse(List<String> data) {
        return data.stream()
                .skip(1)
                .map(d -> d.split(REGEX))
                .map(Transaction::new)
                .collect(Collectors.toList());
    }
}

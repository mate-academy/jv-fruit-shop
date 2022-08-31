package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.ParserService;
import java.util.List;


import static java.util.stream.Collectors.toList;

public class ParserServiceImpl implements ParserService {
    private static final String REGEX = ",";

    @Override
    public List<Transaction> parse(List<String> data) {
            return data.stream()
                    .skip(1)
                    .map(d -> d.split(REGEX))
                    .map(Transaction::new)
                    .collect(toList());
    }
}

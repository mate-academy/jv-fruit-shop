package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvParserService;
import core.basesyntax.service.mapper.StringFruitTransactionMapper;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CsvParserServiceImpl implements CsvParserService<FruitTransaction> {
    private final Function<String, FruitTransaction> fruitTransactionParser;

    public CsvParserServiceImpl() {
        this(new StringFruitTransactionMapper());
    }

    public CsvParserServiceImpl(Function<String, FruitTransaction> fruitTransactionParser) {
        this.fruitTransactionParser = fruitTransactionParser;
    }

    @Override
    public List<FruitTransaction> parse(List<String> records, boolean hasHeader) {
        return records.stream()
                .skip(hasHeader ? 1 : 0)
                .map(fruitTransactionParser)
                .collect(Collectors.toList());
    }
}

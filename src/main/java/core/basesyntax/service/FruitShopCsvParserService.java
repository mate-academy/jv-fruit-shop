package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FruitShopCsvParserService implements CsvParserService<FruitTransaction> {
    private final Function<String, FruitTransaction> fruitTransactionMapper;

    public FruitShopCsvParserService() {
        this(new RecordFruitTransactionMapper());
    }

    public FruitShopCsvParserService(Function<String, FruitTransaction> fruitTransactionMapper) {
        this.fruitTransactionMapper = fruitTransactionMapper;
    }

    @Override
    public List<FruitTransaction> parse(List<String> records, boolean hasHeader) {
        return records.stream()
                .skip(hasHeader ? 1 : 0)
                .map(fruitTransactionMapper)
                .collect(Collectors.toList());
    }
}

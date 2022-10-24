package core.basesyntax.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.operation.OperationStrategy;
import core.basesyntax.repository.FruitStorageRepository;
import core.basesyntax.repository.FruitStorageRepositoryImpl;
import core.basesyntax.service.DataParser;
import core.basesyntax.service.Validator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataParserImpl implements DataParser {
    private final FruitStorageRepository fruitStorageService;
    private final Validator validator;
    private final OperationStrategy strategy;

    public DataParserImpl(OperationStrategy strategy) {
        this.strategy = strategy;
        this.validator = new ValidatorImpl();
        this.fruitStorageService = new FruitStorageRepositoryImpl();
    }

    @Override
    public Map<Fruit, Integer> parseDto(List<FruitRecordDto> records) {
        Map<Fruit, Integer> recordMap = records.stream()
                .filter(validator::validateRecord)
                .map(FruitRecordDto::getFruit)
                .distinct()
                .collect(Collectors.toMap(fruit -> fruit, n -> 0));
        for (FruitRecordDto record : records) {
            recordMap.put(record.getFruit(), strategy.getOperation(record.getType())
                    .operate(recordMap.get(record.getFruit()), record.getAmount()));
        }
        return recordMap;
    }
}

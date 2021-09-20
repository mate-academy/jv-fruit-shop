package core.basesyntax.service;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.operation.OperationStrategy;
import core.basesyntax.repository.FruitStorageRepository;
import core.basesyntax.repository.FruitStorageRepositoryImpl;
import core.basesyntax.validator.Validator;
import core.basesyntax.validator.ValidatorImpl;
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
    public boolean parseAndAddToStorage(List<FruitRecord> records) {
        Map<String, Integer> recordMap = records.stream()
                .filter(validator::validateRecord)
                .map(record -> record.getFruit().getName())
                .distinct()
                .collect(Collectors.toMap(name -> name, n -> 0));
        for (FruitRecord record : records) {
            recordMap.put(record.getFruit().getName(), strategy.getOperation(record.getType())
                    .operate(recordMap.get(record.getFruit().getName()), record.getAmount()));
        }
        fruitStorageService.add(recordMap);
        return true;
    }
}

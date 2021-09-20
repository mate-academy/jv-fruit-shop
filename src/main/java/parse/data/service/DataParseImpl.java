package parse.data.service;

import dao.service.FruitStorageDaoService;
import dao.service.FruitStorageDaoServiceImpl;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.FruitRecord;
import operation.OperationStrategy;
import validator.Validator;
import validator.ValidatorImpl;

public class DataParseImpl implements DataParse {
    private FruitStorageDaoService fruitStorageService = new FruitStorageDaoServiceImpl();
    private Validator validator = new ValidatorImpl();
    private OperationStrategy strategy;

    public DataParseImpl(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public boolean parseAndAddToStorage(List<FruitRecord> records) {
        Map<String, Integer> recordMap = records.stream()
                .map(n -> n.getFruit().getName())
                .distinct()
                .collect(Collectors.toMap(n -> n, n -> 0));
        for (FruitRecord record : records) {
            if (validator.validateRecord(record)) {
                recordMap.put(record.getFruit().getName(), strategy.getOperation(record.getType())
                        .operate(recordMap.get(record.getFruit().getName()), record.getAmount()));
            }
        }
        fruitStorageService.add(recordMap);
        return true;
    }
}

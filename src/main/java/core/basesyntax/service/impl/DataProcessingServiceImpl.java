package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataProcessingService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class DataProcessingServiceImpl implements DataProcessingService {
    private FruitDao fruitDao;
    private OperationStrategy operationStrategy;

    public DataProcessingServiceImpl(FruitDao fruitDao, OperationStrategy operationStrategy) {
        this.fruitDao = fruitDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> getFruit(List<String> linesList) {
        Map<String, Integer> fruitsMap = fruitDao.get();
        linesList.stream()
                .filter(line -> line.startsWith("s") || line.startsWith("b")
                        || line.startsWith("p") || line.startsWith("r"))
                .map(this::getFruitTransaction)
                .forEach(fruitTransaction ->
                        fruitsMap.merge(fruitTransaction.getFruit(),
                                operationStrategy
                                        .getOperationHandler(fruitTransaction.getOperation())
                                        .get(fruitTransaction), Integer::sum)
                );
        return fruitsMap;

    }

    private FruitTransaction getFruitTransaction(String line) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        String[] fields = line.split(",");

        for (int i = 0; i < fields.length; i++) {
            fields[i] = fields[i].trim();
        }
        fruitTransaction.setOperation(FruitTransaction.Operation.getByCode(fields[0]));
        fruitTransaction.setFruit(fields[1]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[2]));
        return fruitTransaction;

    }
}

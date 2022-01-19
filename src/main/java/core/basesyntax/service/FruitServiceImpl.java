package core.basesyntax.service;

import core.basesyntax.dao.FruitRecordDto;
import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.OperationType;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private static final String SEPARATOR = System.getProperty("line.separator");
    private static final String COMA = ",";

    @Override
    public String createReport(Map<OperationType, OperationHandler> operationHandlerMap) {
        for (FruitRecordDto fruitTransaction : ParserCsvImpl.fruitStore) {
            operationHandlerMap.get(fruitTransaction.getType())
                    .apply(fruitTransaction);
        }

        StringBuilder content = new StringBuilder();
        content.append("fruit").append(COMA).append("quantity").append(SEPARATOR);
        for (Map.Entry<Fruit, Integer> entry : FruitStorage.storage.entrySet()) {
            content.append(new Fruit(entry.getKey().getFruitName()))
                    .append(COMA)
                    .append(entry.getValue())
                    .append(SEPARATOR);
        }
        return content.toString();
    }
}

package core.basesyntax.service.fruitservice;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.service.parser.DataParser;
import core.basesyntax.service.parser.DataParserImpl;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.OperationStrategyImpl;
import core.basesyntax.service.strategy.operation.OperationHandler;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {

    @Override
    public void safe(String fromFileName) {
        DataParser dataParser = new DataParserImpl();
        List<FruitRecordDto> fruitRecords = dataParser.parseData(fromFileName);
        Map<String, OperationHandler> operationHandlerMap = new MapInitialize().initializeMap();
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        Map<Fruit, Integer> fruitStorage = Storage.fruitStorage;
        for (FruitRecordDto record : fruitRecords) {
            fruitStorage.put(record.getFruitName(),
                    operationStrategy.get(record.getOperationType())
                            .getAmount(record));
        }
    }
}

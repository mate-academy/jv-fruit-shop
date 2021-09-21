package core.basesyntax.service.transfer;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.parser.DataParser;
import core.basesyntax.service.parser.DataParserImpl;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.OperationStrategyImpl;
import core.basesyntax.service.strategy.operation.OperationHandler;

import java.util.List;
import java.util.Map;

public class FruitTransferImpl implements FruitTransfer {

    @Override
    public Map<String, Integer> transfer(String fromFileName) {
        DataParser dataParser = new DataParserImpl();
        List<FruitRecord> fruitRecords = dataParser.parseData(fromFileName);
        Map<String, OperationHandler> operationHandlerMap = new MapInitialize().initializeMap();
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        Map<String, Integer> fruitStorage = Storage.fruitStorage;
        for (FruitRecord record : fruitRecords) {
            fruitStorage.put(record.getFruitName(),
                    operationStrategy.get(record.getOperationType())
                            .getAmount(record, fruitStorage));
        }
        return fruitStorage;
    }
}

package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParser;
import core.basesyntax.service.DataRecorder;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.impl.DataParserImpl;
import core.basesyntax.service.impl.DataRecorderImpl;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.StrategyImpl;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.PurchaseOperation;
import core.basesyntax.strategy.operation.QuantityOperation;
import core.basesyntax.strategy.operation.ReturnOperation;
import core.basesyntax.strategy.operation.SupplyOperation;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_FROM = "src/main/java/resources/input.csv";
    private static final String FILE_TO = "src/main/java/resources/recorded.csv";
    private static final Map<FruitTransaction.Operation, OperationHandler> operationMap = Map.of(
            FruitTransaction.Operation.PURCHASE, new PurchaseOperation(),
            FruitTransaction.Operation.BALANCE, new QuantityOperation(),
            FruitTransaction.Operation.RETURN, new ReturnOperation(),
            FruitTransaction.Operation.SUPPLY, new SupplyOperation());

    public static void main(String[] args) {
        FileReader reader = new FileReaderImpl();
        List<String> dataFromFile = reader.read(FILE_FROM);

        DataParser parseData = new DataParserImpl();
        List<FruitTransaction> parsedData = parseData.parse(dataFromFile);

        Strategy strategy = new StrategyImpl(operationMap);

        for (FruitTransaction fruitTransaction : parsedData) {
            strategy.getOperation(fruitTransaction);
        }

        DataRecorder recordData = new DataRecorderImpl();
        String finalRecord = recordData.recorder(Storage.storage);
        FileWriter writer = new FileWriterImpl();
        writer.writeToCsv(finalRecord, FILE_TO);
    }
}

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
import core.basesyntax.strategy.impl.StrategyImpl;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.PurchaseOperation;
import core.basesyntax.strategy.operation.QuantityOperation;
import core.basesyntax.strategy.operation.ReturnOperation;
import core.basesyntax.strategy.operation.SupplyOperation;

import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_PATH_TO = "";
    private static final String FILE_PATH_FROM = "";
    private static final Map<FruitTransaction.Operation, OperationHandler> operationMap = Map
            .of(FruitTransaction.Operation.PURCHASE, new PurchaseOperation(),
                    FruitTransaction.Operation.BALANCE, new QuantityOperation(),
                    FruitTransaction.Operation.SUPPLY, new SupplyOperation(),
                    FruitTransaction.Operation.RETURN, new ReturnOperation());

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<String> getDataFromFile = fileReader.readFile(FILE_PATH_FROM);
        DataParser parseData = new DataParserImpl();
        List<FruitTransaction> parsedData = parseData.parse(getDataFromFile);
        Strategy strategy = new StrategyImpl(operationMap);
        for (FruitTransaction fruitTransaction : parsedData) {
            strategy.getOperation(fruitTransaction);
        }
        DataRecorder dataRecorder = new DataRecorderImpl();
        String finishRecord = dataRecorder.recordData(Storage.fruitStorage);
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeDataToCsv(finishRecord, FILE_PATH_TO);
    }
}

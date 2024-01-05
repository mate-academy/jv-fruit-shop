package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileRead;
import core.basesyntax.service.FileWrite;
import core.basesyntax.service.ParseData;
import core.basesyntax.service.RecordData;
import core.basesyntax.service.impl.FileReadImpl;
import core.basesyntax.service.impl.FileWriteImpl;
import core.basesyntax.service.impl.ParseDataImpl;
import core.basesyntax.service.impl.RecordDataImpl;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.StrategyImpl;
import core.basesyntax.strategy.operation.PurchaseOperation;
import core.basesyntax.strategy.operation.QuantityOperation;
import core.basesyntax.strategy.operation.ReturnOperation;
import core.basesyntax.strategy.operation.SupplyOperation;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_FROM = "src/main/java/resources/input.csv";
    private static final String FILE_TO = "src/main/java/resources/recorded.csv";

    public static void main(String[] args) {
        FileRead reader = new FileReadImpl();
        List<String> dataFromFile = reader.read(FILE_FROM);

        ParseData parseData = new ParseDataImpl();
        List<FruitTransaction> parsedData = parseData.parser(dataFromFile);

        Strategy strategy = new StrategyImpl(Map.of(
                FruitTransaction.Operation.PURCHASE, new PurchaseOperation(),
                FruitTransaction.Operation.BALANCE, new QuantityOperation(),
                FruitTransaction.Operation.RETURN, new ReturnOperation(),
                FruitTransaction.Operation.SUPPLY, new SupplyOperation()));

        for (FruitTransaction fruitTransaction : parsedData) {
            strategy.getOperation(fruitTransaction);
        }

        RecordData recordData = new RecordDataImpl();
        String finalRecord = recordData.recorder(Storage.storage);
        FileWrite writer = new FileWriteImpl();
        writer.writeToCsv(finalRecord, FILE_TO);
    }
}

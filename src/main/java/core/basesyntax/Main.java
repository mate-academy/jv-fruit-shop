package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.enums.Operation;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.ReaderCsvImpl;
import core.basesyntax.service.impl.WriterCsvImpl;
import core.basesyntax.strategy.BalanceStrategy;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseStrategy;
import core.basesyntax.strategy.ReturnStrategy;
import core.basesyntax.strategy.SupplyStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/fileToRead/test.csv";
        String outputFilePath = "src/main/resources/fileToWrite/report.csv";

        Map<Operation, OperationStrategy> operationStrategies = new HashMap<>();
        operationStrategies.put(Operation.BALANCE, new BalanceStrategy());
        operationStrategies.put(Operation.SUPPLY, new SupplyStrategy());
        operationStrategies.put(Operation.PURCHASE, new PurchaseStrategy());
        operationStrategies.put(Operation.RETURN, new ReturnStrategy());

        Storage storage = new Storage(operationStrategies);

        ReaderCsvImpl readerService = new ReaderCsvImpl(inputFilePath);
        WriterCsvImpl writerService = new WriterCsvImpl(outputFilePath);
        FruitShopServiceImpl fruitShopService = new FruitShopServiceImpl(storage);

        List<FruitTransaction> parsedTransactionReport = readerService.read();
        writerService.write(fruitShopService.processTransactions(parsedTransactionReport));
    }
}

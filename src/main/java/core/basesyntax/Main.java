package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.StorageToStringService;
import core.basesyntax.service.handlers.BalanceHandler;
import core.basesyntax.service.handlers.PurchaseHandler;
import core.basesyntax.service.handlers.ReturnHandler;
import core.basesyntax.service.handlers.SupplyHandler;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvFileWriterServiceImpl;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.StorageToStringServiceImpl;
import core.basesyntax.service.impl.StringToFruitTransactionListService;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.OperationStrategyImpl;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CsvFileReaderService csvFileReaderService = new CsvFileReaderServiceImpl();
        StringToFruitTransactionListService transactionListService =
                new StringToFruitTransactionListService();
        CsvFileWriterService csvFileWriterService = new CsvFileWriterServiceImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(
                Map.of(FruitTransaction.Operation.BALANCE, new BalanceHandler(),
                        FruitTransaction.Operation.PURCHASE, new PurchaseHandler(),
                        FruitTransaction.Operation.RETURN, new ReturnHandler(),
                        FruitTransaction.Operation.SUPPLY, new SupplyHandler())
        );
        FruitShopService<FruitTransaction> reportCreatorService =
                new FruitShopServiceImpl(operationStrategy);
        StorageToStringService storageToStringService = new StorageToStringServiceImpl();
        String transactions = csvFileReaderService.read("src/main/resources/data.csv");
        reportCreatorService.update(transactionListService.convert(transactions));
        csvFileWriterService.write(storageToStringService.convert());
    }
}

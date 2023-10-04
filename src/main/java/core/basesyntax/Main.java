package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConversionService;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportGenerationService;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.implementation.DataConversionServiceImpl;
import core.basesyntax.service.implementation.FileReaderServiceImpl;
import core.basesyntax.service.implementation.FileWriterServiceImpl;
import core.basesyntax.service.implementation.ReportGenerationServiceImpl;
import core.basesyntax.service.implementation.ShopServiceImpl;
import core.basesyntax.service.implementation.StorageServiceImpl;
import core.basesyntax.strategy.BalanceHandler;
import core.basesyntax.strategy.FruitShopOperationsHandler;
import core.basesyntax.strategy.PurchaseHandler;
import core.basesyntax.strategy.ReturnHandler;
import core.basesyntax.strategy.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final Map<FruitTransaction.Operation, FruitShopOperationsHandler> processSelector
                = new HashMap<>();
        StorageService storageService = new StorageServiceImpl();
        processSelector.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler(storageService));
        processSelector.put(FruitTransaction.Operation.BALANCE, new BalanceHandler(storageService));
        processSelector.put(FruitTransaction.Operation.RETURN, new ReturnHandler(storageService));
        processSelector.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler(storageService));

        String transactionsFile = "src/main/resources/test.csv";
        String reportFile = "src/main/resources/report.csv";
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        String rawData = fileReaderService.read(transactionsFile);

        DataConversionService dataConversionService
                = new DataConversionServiceImpl();
        List<FruitTransaction> convertedData = dataConversionService.convert(rawData);

        ShopService shopService = new ShopServiceImpl();
        for (FruitTransaction transaction : convertedData) {
            shopService.process(transaction, processSelector);
        }

        ReportGenerationService reportGenerationService = new ReportGenerationServiceImpl();
        String report = reportGenerationService.generate();

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.write(report, reportFile);
    }
}

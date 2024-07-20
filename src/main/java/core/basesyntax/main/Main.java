package core.basesyntax.main;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.impl.BalanceHandlerImpl;
import core.basesyntax.strategy.impl.PurchaseHandlerImpl;
import core.basesyntax.strategy.impl.ReturnHandlerImpl;
import core.basesyntax.strategy.impl.SupplyHandlerImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        List<String> csvFile = readerService.readFile("src/main/resources/inputFile.csv");

        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> fruitTransactions = dataConverter.convertToTransactions(csvFile);

        Map<FruitTransaction.Operation, Map<String, Integer>> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE,
                new BalanceHandlerImpl().getBalanceComputedMap(fruitTransactions));
        operationHandlers.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseHandlerImpl().getPurchaseComputedMap(fruitTransactions));
        operationHandlers.put(FruitTransaction.Operation.RETURN,
                new ReturnHandlerImpl().getReturnComputedMap(fruitTransactions));
        operationHandlers.put(FruitTransaction.Operation.SUPPLY,
                new SupplyHandlerImpl().getSupplyComputedMap(fruitTransactions));

        ShopService shopService = new ShopServiceImpl();
        Map<String, Integer> fruitsQuantityAfterDay = shopService.process(operationHandlers);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String generatedReport = reportGenerator.generateReport(fruitsQuantityAfterDay);

        WriterService writerService = new WriterServiceImpl();
        writerService.writeToCsv(generatedReport, "src/main/resources/outputFile.csv");
    }
}

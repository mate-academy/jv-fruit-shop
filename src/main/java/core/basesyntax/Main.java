package core.basesyntax;

import core.basesyntax.converter.ConverterImpl;
import core.basesyntax.converter.ConverterService;
import core.basesyntax.db.Storage;
import core.basesyntax.filereader.FileReaderImpl;
import core.basesyntax.filereader.FileReaderService;
import core.basesyntax.fruittransactionhandler.BalanceHandler;
import core.basesyntax.fruittransactionhandler.OperationHandler;
import core.basesyntax.fruittransactionhandler.PurchaseHandler;
import core.basesyntax.fruittransactionhandler.ReturnHandler;
import core.basesyntax.fruittransactionhandler.SupplyHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.TypeOfTransaction;
import core.basesyntax.operationstrategy.OperationStrategyImpl;
import core.basesyntax.operationstrategy.OperationStrategyService;
import core.basesyntax.reportgenerator.ReportGenerator;
import core.basesyntax.reportgenerator.ReportGeneratorImpl;
import core.basesyntax.shopservice.ShopService;
import core.basesyntax.shopservice.ShopServiceImpl;
import core.basesyntax.writer.WriterImpl;
import core.basesyntax.writer.WriterService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    // HINT: In the `public static void main(String[] args)`
    // it is better to create instances of your classes,
    // and call their methods, but do not write any business
    // logic in the `main` method!
    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderImpl();
        List<String> stringList = fileReaderService
                .read("src/main/resources/inputfile.csv");
        ConverterService converterService = new ConverterImpl();
        Map<TypeOfTransaction, OperationHandler>
                operationHandlerMap = new HashMap<>();
        Storage storageService = new Storage();
        operationHandlerMap.put(TypeOfTransaction.B, new BalanceHandler(storageService));
        operationHandlerMap.put(TypeOfTransaction.P, new PurchaseHandler(storageService));
        operationHandlerMap.put(TypeOfTransaction.R, new ReturnHandler(storageService));
        operationHandlerMap.put(TypeOfTransaction.S, new SupplyHandler(storageService));
        OperationStrategyService operationStrategy =
                new OperationStrategyImpl(operationHandlerMap);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        List<FruitTransaction> fruitTransactions = converterService
                .convertStringToTransaction(stringList);
        shopService.process(fruitTransactions);
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String report = reportGenerator.getReport(storageService);
        WriterService writerService = new WriterImpl();
        writerService.writeDataToFile(report,
                "src/main/resources/report.csv");
    }
}


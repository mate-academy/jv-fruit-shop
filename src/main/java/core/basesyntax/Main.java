package core.basesyntax;

import core.basesyntax.handler.BalanceOperationHandler;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.handler.PurchaseOperationHandler;
import core.basesyntax.handler.ReturnOperationHandler;
import core.basesyntax.handler.SupplyOperationHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportGeneratorService;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorServiceImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] arg) {
        logger.info("Try to reading file");
        FileReaderService fileReader = new FileReaderServiceImpl();
        List<String> inputReport = fileReader.readFile("reportToRead.csv");

        DataConverter dataConverter = new DataConverterImpl();
        final List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGeneratorService reportGenerator = new ReportGeneratorServiceImpl();
        String resultingReport = reportGenerator.getReport();

        FileWriterService fileWriter = new FileWriterServiceImpl();
        fileWriter.write(resultingReport, "finalReport.csv");
    }
}

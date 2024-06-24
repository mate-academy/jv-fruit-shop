package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.ReaderFromCsv;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.WriterToCsv;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.ReaderFromCsvImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.service.impl.WriterToCsvImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationImpl;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperationImpl;
import core.basesyntax.strategy.impl.ReturnOperationImpl;
import core.basesyntax.strategy.impl.SupplyOperationImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String READ_FILE_PATH = "src/main/resources/ReportToRead.csv";
    private static final String WRITE_FILE_PATH = "src/main/resources/FinalReport.csv";

    public static void main(String[] args) {
        ReaderFromCsv fileReader = new ReaderFromCsvImpl();
        List<String> inputReport = fileReader.read(READ_FILE_PATH);

        Map<Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(Operation.BALANCE, new BalanceOperationImpl());
        operationHandlers.put(Operation.PURCHASE, new PurchaseOperationImpl());
        operationHandlers.put(Operation.RETURN, new ReturnOperationImpl());
        operationHandlers.put(Operation.SUPPLY, new SupplyOperationImpl());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String finalReport = reportGenerator.getReport();

        WriterToCsv fileWriter = new WriterToCsvImpl();
        fileWriter.write(finalReport, WRITE_FILE_PATH);
    }
}

package core.basesyntax;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.CsvFileReaderService;
import core.basesyntax.service.impl.CsvFileWriterService;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.BalanceOperation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseOperation;
import core.basesyntax.strategy.ReturnOperation;
import core.basesyntax.strategy.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelloWorld {
    private static final String REPORT_TO_READ_FILE_NAME = "src/main/resources/reportToRead.csv";
    private static final String FINAL_REPORT_FILE_NAME = "src/main/resources/finalReport.csv";

    public static void main(String[] args) {
        FileReaderService fileReader = new CsvFileReaderService();
        List<String> transactions = fileReader.readFromFile(REPORT_TO_READ_FILE_NAME);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        FruitStorage fruitStorage = new FruitStorage();
        ShopService shopService = new ShopServiceImpl(operationStrategy,fruitStorage);

        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> fruitTransactions =
                dataConverter.convertToTransactions(transactions);
        shopService.process(fruitTransactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl(fruitStorage);
        String report = reportGenerator.createReport();

        FileWriterService fileWriter = new CsvFileWriterService();
        fileWriter.writeToFile(report, FINAL_REPORT_FILE_NAME);

    }
}

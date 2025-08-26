package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.CsvFileReader;
import service.CsvFileWriter;
import service.ReportGenerator;
import service.ShopService;
import service.impl.CsvFileReaderImpl;
import service.impl.CsvFileWriterImpl;
import service.impl.ReportGeneratorImpl;
import service.impl.ShopServiceImpl;
import strategy.OperationHandler;
import strategy.OperationStrategy;
import strategy.impl.BalanceOperation;
import strategy.impl.OperationStrategyImpl;
import strategy.impl.PurchaseOperation;
import strategy.impl.ReturnOperation;
import strategy.impl.SupplyOperation;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE = "src/main/resources/finalReport.csv";

    public static void main(String[] args) {
        CsvFileReader reader = new CsvFileReaderImpl();

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        List<String> transactions = reader.read(INPUT_FILE);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();

        CsvFileWriter fileWriter = new CsvFileWriterImpl();
        fileWriter.write(resultingReport, OUTPUT_FILE);
    }
}

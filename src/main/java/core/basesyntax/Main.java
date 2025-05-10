package core.basesyntax;

import db.Storage;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.DataConverter;
import service.FileReader;
import service.ReportGenerator;
import service.ShopService;
import service.impl.DataConverterImpl;
import service.impl.FileReaderImpl;
import service.impl.FileWriterImpl;
import service.impl.OperationStrategyImpl;
import service.impl.ReportGeneratorImpl;
import service.impl.ShopServiceImpl;
import service.operation.BalanceOperation;
import service.operation.OperationHandler;
import service.operation.PurchaseOperation;
import service.operation.ReturnOperation;
import service.operation.SupplyOperation;
import strategy.OperationStrategy;

public class Main {
    private static final String REPORT_TO_READ_FILE = "src/main/resources/reportToRead.csv";
    private static final String FINAL_REPORT_FILE = "src/main/resources/finalReport.csv";

    public static void main(String[] args) throws FileNotFoundException {
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read(REPORT_TO_READ_FILE);

        DataConverter dataConverter = new DataConverterImpl();

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        Storage storage = new Storage();
        ReportGenerator reportGenerator = new ReportGeneratorImpl(storage);
        String resultingReport = reportGenerator.getReport();

        FileWriterImpl fileWriter = new FileWriterImpl();
        fileWriter.write(FINAL_REPORT_FILE, resultingReport);
    }
}

package core.basesyntax;

import db.Storage;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Transaction;
import service.Converter;
import service.FileReader;
import service.ReportGenerator;
import service.ShopService;
import service.impl.ConverterImpl;
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
    private static final String INPUT_FILE = "src/main/resources/inputReport.csv";
    private static final String OUTPUT_FILE = "src/main/resources/outputReport.csv";

    public static void main(String[] args) throws FileNotFoundException {
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read(INPUT_FILE);

        Converter converter = new ConverterImpl();

        Storage storage = new Storage();
        Map<Transaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Transaction.Operation.BALANCE, new BalanceOperation());
        operationHandlerMap.put(Transaction.Operation.SUPPLY, new SupplyOperation());
        operationHandlerMap.put(Transaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlerMap.put(Transaction.Operation.RETURN, new ReturnOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        List<Transaction> transactionList = converter.convertTransaction(inputReport);
        ShopService shopService = new ShopServiceImpl(operationStrategy, storage);
        shopService.process(transactionList);

        ReportGenerator reportGenerator = new ReportGeneratorImpl(storage);
        String reportResult = reportGenerator.getReport();

        FileWriterImpl fileWriter = new FileWriterImpl();
        fileWriter.write(OUTPUT_FILE, reportResult);
    }
}

package app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.DataConverter;
import service.ReaderService;
import service.ReportGenerator;
import service.ShopService;
import service.WriterService;
import service.impl.DataConverterImpl;
import service.impl.FileReaderImpl;
import service.impl.FileWriterImpl;
import service.impl.ReportGeneratorImpl;
import service.impl.ShopServiceImpl;
import strategy.BalanceOperation;
import strategy.OperationHandler;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;
import strategy.PurchaseOperation;
import strategy.ReturnOperation;
import strategy.SupplyOperation;

public class Main {
    public static void main(String[] args) {
        final String inputFile = "src/main/resources/reportToRead.csv";
        final String outputFile = "src/main/resources/finalReport.csv";

        ReaderService readerService = new FileReaderImpl();
        final List<String> inputData = readerService.read(inputFile);

        DataConverter dataConverter = new DataConverterImpl();
        final List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputData);

        Map<FruitTransaction.Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        handlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        handlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        handlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());

        OperationStrategy operationStrategy = new OperationStrategyImpl(handlers);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String report = reportGenerator.getReport();

        WriterService writerService = new FileWriterImpl();
        writerService.write(report, outputFile);
    }
}


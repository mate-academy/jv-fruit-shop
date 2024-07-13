package main;

import io.FileReader;
import io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import model.Operation;
import service.DataConverter;
import service.OperationHandler;
import service.ReportGenerator;
import service.ShopService;
import service.impl.BalanceOperationHandler;
import service.impl.DataConverterGetter;
import service.impl.FileReaderImpl;
import service.impl.FileWriterImpl;
import service.impl.PurchaseOperationHandler;
import service.impl.ReportGeneratorImpl;
import service.impl.ReturnOperationHandler;
import service.impl.ShopServiceImpl;
import service.impl.SupplyOperationHandler;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Main <reportToReadFilePath> <finalReportFilePath>");
            return;
        }

        String reportToReadFilePath = args[0];
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read(reportToReadFilePath);

        DataConverter dataConverter = DataConverterGetter.getDataConverter();
        Map<Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(Operation.BALANCE, new BalanceOperationHandler());
        operationHandlers.put(Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlers.put(Operation.RETURN, new ReturnOperationHandler());
        operationHandlers.put(Operation.SUPPLY, new SupplyOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator
                .getReport(((ShopServiceImpl) shopService)
                        .getStorage());

        String finalReportFilePath = args[1];
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, finalReportFilePath);
    }
}

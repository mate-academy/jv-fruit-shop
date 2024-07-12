package main;

import dao.FileReader;
import dao.FileReaderImpl;
import dao.FileWriter;
import dao.FileWriterImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.BalanceOperationHandler;
import service.OperationHandler;
import service.PurchaseOperationHandler;
import service.ReportGenerator;
import service.ReportGeneratorImpl;
import service.ReturnOperationHandler;
import service.ShopService;
import service.ShopServiceImpl;
import service.SupplyOperationHandler;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;
import util.DataConverter;
import util.DataConverterImpl;

public class Main {
    public static void main(String[] args) {
        String reportToReadFilePath = "src/main/resources/reportToRead.csv";
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read(reportToReadFilePath);

        DataConverter dataConverter = new DataConverterImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator
                .getReport(((ShopServiceImpl) shopService)
                .getStorage());

        FileWriter fileWriter = new FileWriterImpl();
        String finalReportFilePath = "src/main/resources/finalReport.csv";
        fileWriter.write(resultingReport, finalReportFilePath);
    }
}

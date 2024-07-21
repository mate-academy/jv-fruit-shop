package main;

import io.FileReader;
import io.FileReaderImpl;
import io.FileWriter;
import io.FileWriterImpl;
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
import service.impl.PurchaseOperationHandler;
import service.impl.ReportGeneratorImpl;
import service.impl.ReturnOperationHandler;
import service.impl.ShopServiceImpl;
import service.impl.Storage;
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
        Map<Operation, OperationHandler> operationHandlers = Map.of(
                Operation.BALANCE, new BalanceOperationHandler(),
                Operation.PURCHASE, new PurchaseOperationHandler(),
                Operation.RETURN, new ReturnOperationHandler(),
                Operation.SUPPLY, new SupplyOperationHandler()
        );
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        Storage storage = new Storage();
        ShopService shopService = new ShopServiceImpl(operationStrategy, storage);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport(storage);
        String finalReportFilePath = args[1];
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, finalReportFilePath);
    }
}

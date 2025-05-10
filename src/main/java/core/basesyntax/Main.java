package core.basesyntax;

import core.basesyntax.dataconverter.DataConverter;
import core.basesyntax.dataconverter.DataConverterImpl;
import core.basesyntax.filereader.FileReader;
import core.basesyntax.filereader.FileReaderImpl;
import core.basesyntax.filewriter.FileWriter;
import core.basesyntax.filewriter.FileWriterImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operationservice.BalanceOperationImpl;
import core.basesyntax.operationservice.OperationHandler;
import core.basesyntax.operationservice.PurchaseOperationImpl;
import core.basesyntax.operationservice.ReturnOperationImpl;
import core.basesyntax.operationservice.SupplyOperationImpl;
import core.basesyntax.operationstrategy.OperationStrategy;
import core.basesyntax.operationstrategy.OperationStrategyImpl;
import core.basesyntax.reportgenerator.ReportGenerator;
import core.basesyntax.reportgenerator.ReportGeneratorImpl;
import core.basesyntax.shopservice.ShopService;
import core.basesyntax.shopservice.ShopServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String pathToRead = "src/main/java/resources/reportToRead.csv";
    private static final String pathToWrite = "src/main/java/resources/finalReport.csv";

    public static void main(String[] args) {

        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read(pathToRead);

        DataConverter dataConverter = new DataConverterImpl();

        Map<FruitTransaction.Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperationImpl());
        handlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationImpl());
        handlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationImpl());
        handlers.put(FruitTransaction.Operation.RETURN, new ReturnOperationImpl());
        OperationStrategy operationStrategy = new OperationStrategyImpl(handlers);

        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, pathToWrite);
    }
}

package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.DataConverter;
import service.FileReader;
import service.FileWriter;
import service.OperationHandler;
import service.OperationStrategy;
import service.ReportGenerator;
import service.ShopService;
import service.impl.DataConverterImpl;
import service.impl.FileReaderImpl;
import service.impl.FileWriterImpl;
import service.impl.OperationStrategyImpl;
import service.impl.ReportGeneratorImpl;
import service.impl.ShopServiceImpl;
import strategy.BalanceOperation;
import strategy.PurchaseOperation;
import strategy.ReturnOperation;
import strategy.SupplyOperation;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/reportToRead.csv";
    private static final String OUTPUT_FILE = "src/main/resources/finalReport.csv";

    public static void main(String[] arg) {
        FileReader fileReader = new FileReaderImpl();
        List<String> readingFile = fileReader.read(INPUT_FILE);

        DataConverter dataConverter = new DataConverterImpl();

        Map<FruitTransaction.Operation, OperationHandler> strategy = new HashMap<>();
        strategy.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        strategy.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        strategy.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        strategy.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());

        OperationStrategy operationStrategy = new OperationStrategyImpl(strategy);
        ShopService shopService = new ShopServiceImpl(operationStrategy);

        List<FruitTransaction> transactions = dataConverter.convertToTransaction(readingFile);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String report = reportGenerator.getReport();

        FileWriter fileWriterService = new FileWriterImpl();
        fileWriterService.write(OUTPUT_FILE, report);
    }
}

package fruitshop;

import fruitshop.model.FruitTransaction;
import fruitshop.model.Storage;
import fruitshop.service.DataConverter;
import fruitshop.service.FileReader;
import fruitshop.service.FileWriter;
import fruitshop.service.ReportGenerator;
import fruitshop.service.ShopService;
import fruitshop.service.impl.DataConverterImpl;
import fruitshop.service.impl.FileReaderImpl;
import fruitshop.service.impl.FileWriterImpl;
import fruitshop.service.impl.ReportGeneratorImpl;
import fruitshop.service.impl.ShopServiceImpl;
import fruitshop.strategy.BalanceOperation;
import fruitshop.strategy.OperationHandler;
import fruitshop.strategy.OperationStrategy;
import fruitshop.strategy.OperationStrategyImpl;
import fruitshop.strategy.PurchaseOperation;
import fruitshop.strategy.ReturnOperation;
import fruitshop.strategy.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String READ_FILE_PATH = "src/main/resources/reportToRead.csv";
    public static final String WRITE_FILE_PATH = "src/main/resources/finalReport.csv";

    public static void main(String[] arg) {
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read(READ_FILE_PATH);

        Storage storage = new Storage();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation(storage));
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation(storage));
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation(storage));
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation(storage));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, WRITE_FILE_PATH);
    }
}

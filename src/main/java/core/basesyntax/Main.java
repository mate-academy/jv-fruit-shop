package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import service.DataConverter;
import service.FileReader;
import service.FileWriter;
import service.ReportCreating;
import service.ShopService;
import service.impl.DataConverterImpl;
import service.impl.FileReaderImpl;
import service.impl.FileWriterImpl;
import service.impl.ReportCreatingImpl;
import service.impl.ShopServiceImpl;
import strategy.OperationHandler;
import strategy.OperationStrategy;
import strategy.impl.BalanceOperationHandler;
import strategy.impl.OperationStrategyImpl;
import strategy.impl.PurchaseOperationHandler;
import strategy.impl.ReturnAndSupplyOpHandler;

public class Main {
    public static final String DATA_PATH = "src/main/java/resources/reportToRead.csv";
    public static final String RESULT_PATH = "src/main/java/resources/finalReport.csv";

    public static void main(String[] args) {

        FileReader fileReader = new FileReaderImpl();
        List<String> fileToRead = fileReader.readFile(DATA_PATH);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap
                = new HashMap<>();
        operationHandlerMap.put(
                FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(
                FruitTransaction.Operation.RETURN, new ReturnAndSupplyOpHandler());
        operationHandlerMap.put(
                FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(
                FruitTransaction.Operation.SUPPLY, new ReturnAndSupplyOpHandler());
        OperationStrategy operationStrategy =
                new OperationStrategyImpl(operationHandlerMap);

        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions =
                dataConverter.convertToTransaction(fileToRead);

        ShopService service = new ShopServiceImpl(operationStrategy);
        service.process(transactions);

        ReportCreating reportCreating = new ReportCreatingImpl();
        String generatedReport = reportCreating.generateReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeFile(RESULT_PATH, generatedReport);

    }
}

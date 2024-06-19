package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import model.Operation;
import service.DataConverter;
import service.FileReader;
import service.FileWriter;
import service.ReportGenerator;
import service.ShopService;
import service.impl.DataConverterImpl;
import service.impl.FileReaderImpl;
import service.impl.FileWriterImpl;
import service.impl.ReportGeneratorImpl;
import service.impl.ShopServiceImpl;
import strategy.OperationHandler;
import strategy.OperationStrategy;
import strategy.impl.BalanceOperation;
import strategy.impl.OperationStrategyImpl;
import strategy.impl.PurchaseOperation;
import strategy.impl.ReturnOperation;
import strategy.impl.SupplyOperation;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/reportToRead.csv";
    private static final String OUTPUT_FILE = "src/main/resources/finalReport.csv";

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read(INPUT_FILE);

        Map<Operation, OperationHandler> operationHandlers = getMap();
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, OUTPUT_FILE);
    }

    private static Map<Operation, OperationHandler> getMap() {
        Map<Operation, OperationHandler> map = new HashMap<>();
        map.put(Operation.BALANCE, new BalanceOperation());
        map.put(Operation.PURCHASE, new PurchaseOperation());
        map.put(Operation.RETURN, new ReturnOperation());
        map.put(Operation.SUPPLY, new SupplyOperation());
        return map;
    }
}

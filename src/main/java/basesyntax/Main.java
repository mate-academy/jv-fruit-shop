package basesyntax;

import basesyntax.common.FruitTransaction;
import basesyntax.service.DataConverter;
import basesyntax.service.FileReader;
import basesyntax.service.FileWriter;
import basesyntax.service.OperationStrategy;
import basesyntax.service.ReportGenerator;
import basesyntax.service.ShopService;
import basesyntax.serviceimpl.DataConverterImpl;
import basesyntax.serviceimpl.FileReaderImpl;
import basesyntax.serviceimpl.FileWriterImpl;
import basesyntax.serviceimpl.OperationStrategyImpl;
import basesyntax.serviceimpl.ReportGeneratorImpl;
import basesyntax.serviceimpl.ShopServiceImpl;
import basesyntax.strategy.BalanceOperation;
import basesyntax.strategy.OperationHandler;
import basesyntax.strategy.PurchaseOperation;
import basesyntax.strategy.ReturnOperation;
import basesyntax.strategy.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/data.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        DataConverter dataConverter = new DataConverterImpl();

        Map<FruitTransaction.Operation, OperationHandler> handlerMap = new HashMap<>();
        handlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        handlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        handlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        handlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperation());

        OperationStrategy operationStrategy = new OperationStrategyImpl(handlerMap);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        FileWriter fileWriter = new FileWriterImpl();

        List<String> rawData = fileReader.read(INPUT_FILE_PATH);
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(rawData);
        shopService.process(transactions);
        String report = reportGenerator.getReport();
        fileWriter.write(report, OUTPUT_FILE_PATH);
        System.out.println("The report is successfully generated into a file: "
                + OUTPUT_FILE_PATH);
    }
}

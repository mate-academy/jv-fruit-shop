package core.basesyntax;

import core.basesyntax.service.converter.DataConverter;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.strategy.BalanceOperation;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        String content = "type,fruit,quantity\nb,banana,23\ns,banana,100\np,banana,13\nr,banana,11";
        FileCreator.createFile(content);

        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read(FileCreator.REPORT_FILE_PATH);

        DataConverter dataConverter = new DataConverterImpl();
        final var transactions = dataConverter.convertToTransaction(inputReport);
        Map<String, Integer> storage = new HashMap<>();
        Map<Operation, OperationHandler> operationHandlers = Map.of(
                Operation.BALANCE, new BalanceOperation(storage),
                Operation.PURCHASE, new PurchaseOperation(storage),
                Operation.RETURN, new ReturnOperation(storage),
                Operation.SUPPLY, new SupplyOperation(storage)
        );

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport(shopService.getStorage());

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, "finalReport.csv");
    }
}

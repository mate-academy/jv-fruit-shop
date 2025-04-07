package core.basesyntax;

import core.basesyntax.converter.DataConverter;
import core.basesyntax.converter.DataConverterImpl;
import core.basesyntax.file.FileReader;
import core.basesyntax.file.FileReaderImpl;
import core.basesyntax.file.FileWriter;
import core.basesyntax.file.FileWriterImpl;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.OperationStrategy;
import core.basesyntax.operation.OperationStrategyImpl;
import core.basesyntax.operation.handler.BalanceOperation;
import core.basesyntax.operation.handler.PurchaseOperation;
import core.basesyntax.operation.handler.ReturnOperation;
import core.basesyntax.operation.handler.SupplyOperation;
import core.basesyntax.reportgenerator.ReportGenerator;
import core.basesyntax.reportgenerator.ReportGeneratorImpl;
import core.basesyntax.shopservice.ShopService;
import core.basesyntax.shopservice.ShopServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_TO_READ = "src/main/resource/reportToRead.csv";
    private static final String FILE_TO_WRITE = "src/main/resource/finalReport.csv";

    public static void main(String[] arg) {

        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read(FILE_TO_READ);

        DataConverter dataConverter = new DataConverterImpl();
        List<String> dataWithoutHeader = dataConverter.removeHeader(inputReport);
        final List<FruitTransaction> transactions =
                dataConverter.convertToTransaction(dataWithoutHeader);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, FILE_TO_WRITE);
    }
}

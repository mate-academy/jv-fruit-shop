package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.file.parser.DataConverter;
import core.basesyntax.service.file.parser.DataConverterImpl;
import core.basesyntax.service.file.reader.FileReader;
import core.basesyntax.service.file.reader.FileReaderImpl;
import core.basesyntax.service.file.writer.FileWriter;
import core.basesyntax.service.file.writer.FileWriterImpl;
import core.basesyntax.service.report.ReportGenerator;
import core.basesyntax.service.report.ReportGeneratorImpl;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.OperationStrategyImpl;
import core.basesyntax.service.strategy.operations.BalanceOperation;
import core.basesyntax.service.strategy.operations.OperationHandler;
import core.basesyntax.service.strategy.operations.PurchaseOperation;
import core.basesyntax.service.strategy.operations.ReturnOperation;
import core.basesyntax.service.strategy.operations.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String SOURCE_PATH = "src/main/resources/file.csv";
    public static final String REPORT_PATH = "src/main/resources/report.csv";

    public static void main(String[] arg) {
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read(SOURCE_PATH);

        DataConverter dataConverter = new DataConverterImpl();

        StorageDao storageDao = new StorageDaoImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation(storageDao));
        operationHandlers.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperation(storageDao));
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation(storageDao));
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation(storageDao));

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl(storageDao);
        String resultingReport = reportGenerator.getReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, REPORT_PATH);
    }
}

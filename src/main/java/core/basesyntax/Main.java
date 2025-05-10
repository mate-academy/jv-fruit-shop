package core.basesyntax;

import core.basesyntax.impl.DataConverterImpl;
import core.basesyntax.impl.FileReaderImpl;
import core.basesyntax.impl.FileWriterImpl;
import core.basesyntax.impl.ReportGeneratorImpl;
import core.basesyntax.impl.ShopServiceImpl;
import core.basesyntax.impl.StorageServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.StorageService;
import core.basesyntax.strategy.BalanceOperation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseOperation;
import core.basesyntax.strategy.ReturnOperation;
import core.basesyntax.strategy.SupplyOperation;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_NAME_FOR_READ
            = "src/main/java/resources/reportToRead.csv";
    private static final String FILE_NAME_FOR_WRITE
            = "src/main/java/resources/reportToWrite.csv";

    public static void main(String[] args) {
        StorageService storageService = new StorageServiceImpl();
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.readFromFile(FILE_NAME_FOR_READ);

        DataConverter dataConverter = new DataConverterImpl();

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = Map
                .of(FruitTransaction.Operation.BALANCE, new BalanceOperation(storageService),
                        FruitTransaction.Operation.PURCHASE, new PurchaseOperation(storageService),
                        FruitTransaction.Operation.RETURN, new ReturnOperation(storageService),
                        FruitTransaction.Operation.SUPPLY, new SupplyOperation(storageService));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(resultingReport, FILE_NAME_FOR_WRITE);
    }
}

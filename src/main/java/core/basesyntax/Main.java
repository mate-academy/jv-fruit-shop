package core.basesyntax;

import core.basesyntax.converter.DataConverter;
import core.basesyntax.converter.DataConverterImpl;
import core.basesyntax.db.FruitDao;
import core.basesyntax.db.FruitDaoImpl;
import core.basesyntax.file.operations.FIleWriterImpl;
import core.basesyntax.file.operations.FileReader;
import core.basesyntax.file.operations.FileReaderImpl;
import core.basesyntax.file.operations.FileWriter;
import core.basesyntax.operation.BalanceOperation;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.PurchaseOperation;
import core.basesyntax.operation.ReturnOperation;
import core.basesyntax.operation.SupplyOperation;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ReportGeneratorImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.transaction.FruitTransaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/reportToRead.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/outputReport.csv";

    public static void main(String[] args) {

        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read(INPUT_FILE_PATH);

        DataConverter dataConverter = new DataConverterImpl();

        FruitDao fruitDao = new FruitDaoImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.B, new BalanceOperation(fruitDao));
        operationHandlers.put(FruitTransaction.Operation.P, new PurchaseOperation(fruitDao));
        operationHandlers.put(FruitTransaction.Operation.R, new ReturnOperation(fruitDao));
        operationHandlers.put(FruitTransaction.Operation.S, new SupplyOperation(fruitDao));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        List<FruitTransaction> transactions = dataConverter
                .convertDataFromInputCsvFile(inputReport);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.processTransaction(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.generateReport();

        FileWriter fileWriter = new FIleWriterImpl();
        fileWriter.writeToFile(OUTPUT_FILE_PATH, resultingReport);
    }
}

package core.basesyntax;

import core.basesyntax.converter.DataConverter;
import core.basesyntax.converter.DataConverterImpl;
import core.basesyntax.db.FruitDao;
import core.basesyntax.db.FruitDaoImpl;
import core.basesyntax.file.operations.FileReader;
import core.basesyntax.file.operations.FileReaderImpl;
import core.basesyntax.file.operations.FileWriterImpl;
import core.basesyntax.file.operations.ReportFileWriter;
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
import java.io.IOException;
import java.util.EnumMap;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/reportToRead.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/outputReport.csv";

    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read(INPUT_FILE_PATH);

        DataConverter dataConverter = new DataConverterImpl();

        FruitDao fruitDao = new FruitDaoImpl();
        EnumMap<FruitTransaction.Operation, OperationHandler> operationHandlers =
                new EnumMap<>(FruitTransaction.Operation.class);
        operationHandlers.put(FruitTransaction.Operation.B, new BalanceOperation(fruitDao));
        operationHandlers.put(FruitTransaction.Operation.P, new PurchaseOperation(fruitDao));
        operationHandlers.put(FruitTransaction.Operation.R, new ReturnOperation(fruitDao));
        operationHandlers.put(FruitTransaction.Operation.S, new SupplyOperation(fruitDao));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        List<FruitTransaction> transactions = dataConverter
                .convertFromCsv(inputReport);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.processTransactions(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.generateReport();

        ReportFileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(OUTPUT_FILE_PATH, resultingReport);
    }
}

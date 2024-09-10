package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.db.impl.StorageImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.CustomFileReader;
import core.basesyntax.service.CustomFileWriter;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.CustomFileReaderImpl;
import core.basesyntax.service.impl.CustomFileWriterImpl;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperation;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperation;
import core.basesyntax.strategy.impl.ReturnOperation;
import core.basesyntax.strategy.impl.SupplyOperation;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final String inputPath = "src/main/resources/input.csv";
        final String outputPath = "src/main/resources/output.csv";
        CustomFileReader fileReader = new CustomFileReaderImpl();
        DataConverter dataConverter = new DataConverterImpl();
        CustomFileWriter fileWriter = new CustomFileWriterImpl();
        Storage storage = new StorageImpl();

        Map<Operation, OperationHandler> operationHandlers = Map.of(
                Operation.BALANCE, new BalanceOperation(),
                Operation.PURCHASE, new PurchaseOperation(),
                Operation.RETURN, new ReturnOperation(),
                Operation.SUPPLY, new SupplyOperation()
        );
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        ShopService shopService = new ShopServiceImpl(operationStrategy, storage);
        ReportGenerator reportGenerator = new ReportGeneratorImpl(storage);

        List<String> inputReport;
        try {
            inputReport = fileReader.read(inputPath);
        } catch (IOException e) {
            throw new RuntimeException("Can't find the specified file:" + inputPath, e);
        }
        List<FruitTransaction> transactions = dataConverter.convert(inputReport);

        shopService.process(transactions);
        String resultingReport = reportGenerator.getReport();

        try {
            fileWriter.write(resultingReport, outputPath);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to the specified file:" + outputPath, e);
        }
    }
}

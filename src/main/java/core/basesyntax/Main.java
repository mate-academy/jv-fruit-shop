package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.db.impl.StorageImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperation;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperation;
import core.basesyntax.strategy.impl.ReturnOperation;
import core.basesyntax.strategy.impl.SupplyOperation;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final String inputPath = "src/main/resources/input.csv";
        final String outputPath = "src/main/resources/output.csv";
        FileReader fileReader = new FileReaderImpl();
        DataConverter dataConverter = new DataConverterImpl();
        FileWriter fileWriter = new FileWriterImpl();
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

        List<String> inputReport = fileReader.read(inputPath);
        List<FruitTransaction> transactions = dataConverter.convert(inputReport);

        shopService.process(transactions);
        String resultingReport = reportGenerator.getReport();

        fileWriter.write(resultingReport, outputPath);
    }
}

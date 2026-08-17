package core.basesyntax;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FileWriterImpl;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperation;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperation;
import core.basesyntax.strategy.impl.ReturnOperation;
import core.basesyntax.strategy.impl.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE =
            "src/main/resources/reportToRead.csv";
    private static final String OUTPUT_FILE =
            "src/main/resources/finalReport.csv";

    public static void main(String[] args) {

        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read(INPUT_FILE);

        FruitStorage storage = new Storage();
        Map<FruitTransaction.Operation, OperationHandler> handlers =
                new HashMap<>();
        handlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation(storage));

        handlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation(storage));

        handlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation(storage));

        handlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation(storage));

        OperationStrategy operationStrategy = new OperationStrategyImpl(handlers);
        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions =
                dataConverter.convertToTransaction(inputReport);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);
        ReportGenerator reportGenerator = new ReportGeneratorImpl(storage);
        String report = reportGenerator.getReport();
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(report, OUTPUT_FILE);

    }
}

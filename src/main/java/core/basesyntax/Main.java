package core.basesyntax;

import core.basesyntax.file.FileReader;
import core.basesyntax.file.FileReaderImpl;
import core.basesyntax.file.FileWriter;
import core.basesyntax.file.FileWriterImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.DataConverterImpl;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ReportGeneratorImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.strategy.BalanceOperation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseOperation;
import core.basesyntax.strategy.ReturnOperation;
import core.basesyntax.strategy.SupplyOperation;
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
        List<String> inputData = fileReader.read(INPUT_FILE);

        DataConverter dataConverter = new DataConverterImpl();

        Map<FruitTransaction.Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        handlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        handlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        handlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());

        OperationStrategy operationStrategy = new OperationStrategyImpl(handlers);
        ShopService shopService = new ShopServiceImpl(operationStrategy);

        List<FruitTransaction> transactions =
                dataConverter.convertToTransaction(inputData);

        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String report = reportGenerator.getReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(report, OUTPUT_FILE);
    }
}

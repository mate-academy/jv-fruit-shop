package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.service.impl.FileParserService;
import core.basesyntax.service.impl.FileReaderService;
import core.basesyntax.service.impl.FileWriterService;
import core.basesyntax.service.impl.ReportGeneratorService;
import core.basesyntax.service.impl.TransactionProcessService;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        final FileReaderService readFromFile = new FileReaderService();
        final FileParserService fileParser = new FileParserService();
        OperationStrategy operationStrategy = new OperationStrategyImpl(mapInitializer());
        final TransactionProcessService dataProcess =
                new TransactionProcessService(operationStrategy);
        final ReportGeneratorService reportGenerator = new ReportGeneratorService();
        final FileWriterService writeToFile = new FileWriterService();

        dataProcess.process(fileParser
                .parse(readFromFile.read(INPUT_FILE)));
        writeToFile.write(reportGenerator
                .createReport(), OUTPUT_FILE);
    }

    private static Map<String, OperationHandler> mapInitializer() {
        return Map.of(Operation.BALANCE.getCode(), new BalanceOperationHandler(),
                Operation.PURCHASE.getCode(), new PurchaseOperationHandler(),
                Operation.RETURN.getCode(), new ReturnOperationHandler(),
                Operation.SUPPLY.getCode(), new SupplyOperationHandler());
    }
}

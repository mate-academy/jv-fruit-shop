package core.basesyntax;

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
        OperationStrategy activitiesStrategy = new OperationStrategyImpl(mapInitializer());
        final TransactionProcessService dataProcess =
                new TransactionProcessService(activitiesStrategy);
        final ReportGeneratorService createReport = new ReportGeneratorService();
        final FileWriterService writeToFile = new FileWriterService();

        writeToFile.write(createReport
                .createReport(dataProcess.process(fileParser
                        .parse(readFromFile.read(INPUT_FILE)))), OUTPUT_FILE);
    }

    private static Map<String, OperationHandler> mapInitializer() {
        return Map.of("b", new BalanceOperationHandler(),
                "p", new PurchaseOperationHandler(),
                "r", new ReturnOperationHandler(),
                "s", new SupplyOperationHandler());
    }
}

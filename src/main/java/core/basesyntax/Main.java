package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FileRead;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReportWriteService;
import core.basesyntax.service.impl.FileReadImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReportWriteServiceImpl;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.List;
import java.util.Map;

public class Main {

    private static final String INPUT_FILE_NAME = "src/main/resources/database.csv";
    private static final String REPORT_FILE_NAME = "src/main/resources/result.csv";

    public static void main(String[] args) {
        Map<Operation, OperationHandler> strategyMap = Map.of(
                Operation.BALANCE, new BalanceOperationHandler(),
                Operation.SUPPLY, new SupplyOperationHandler(),
                Operation.PURCHASE, new PurchaseOperationHandler(),
                Operation.RETURN, new ReturnOperationHandler());

        OperationStrategy strategy = new OperationStrategy(strategyMap);

        FileRead reader = new FileReadImpl();
        ParserService parser = new ParserServiceImpl();
        FruitService fruitService = new FruitServiceImpl(strategy);
        ReportWriteService reportWriteService = new ReportWriteServiceImpl();
        FileWriter writer = new FileWriterImpl();

        List<String> lines = reader.readFileContents(INPUT_FILE_NAME);
        List<FruitTransaction> transactions = parser.getFromCsvRow(lines);
        Map<String, Integer> report = fruitService.process(transactions);
        List<String> newReport = reportWriteService.writeReport(report);
        writer.write(newReport, REPORT_FILE_NAME);
    }
}

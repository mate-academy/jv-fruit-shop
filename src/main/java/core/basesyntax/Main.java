package core.basesyntax;

import core.basesyntax.model.OperationType;
import core.basesyntax.operation.BalanceOperationHandler;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.OperationStrategy;
import core.basesyntax.operation.PurchaseOperationHandler;
import core.basesyntax.operation.ReturnOperationHandler;
import core.basesyntax.operation.SupplyOperationHandler;
import core.basesyntax.service.parser.OperationParser;
import core.basesyntax.service.parser.OperationParserImpl;
import core.basesyntax.service.reader.InputDataReader;
import core.basesyntax.service.reader.InputDataReaderImpl;
import core.basesyntax.service.report.DailyReportService;
import core.basesyntax.service.report.DailyReportServiceImpl;
import core.basesyntax.service.report.FruitAmountCounter;
import core.basesyntax.service.report.FruitAmountCounterImpl;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        InputDataReader readFile = new InputDataReaderImpl(INPUT_FILE_PATH);
        Map<OperationType, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(OperationType.b, new BalanceOperationHandler());
        operationHandlerMap.put(OperationType.p, new PurchaseOperationHandler());
        operationHandlerMap.put(OperationType.s, new SupplyOperationHandler());
        operationHandlerMap.put(OperationType.r, new ReturnOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategy(operationHandlerMap);
        OperationParser operationParser = new OperationParserImpl(readFile);
        FruitAmountCounter fruitAmountCounter;
        fruitAmountCounter = new FruitAmountCounterImpl(operationStrategy, operationParser);
        DailyReportService dailyReportService = new DailyReportServiceImpl(fruitAmountCounter);
        dailyReportService.createReport(OUTPUT_FILE_PATH);
    }
}

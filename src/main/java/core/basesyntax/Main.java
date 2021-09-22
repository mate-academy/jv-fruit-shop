package core.basesyntax;

import core.basesyntax.model.OperationType;
import core.basesyntax.model.TransactionDto;
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
import core.basesyntax.service.report.FruitService;
import core.basesyntax.service.report.FruitServiceImpl;
import core.basesyntax.service.writer.ReportWriter;
import core.basesyntax.service.writer.ReportWriterImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        InputDataReader readFile = new InputDataReaderImpl();
        Map<OperationType, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(OperationType.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(OperationType.PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(OperationType.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(OperationType.RETURN, new ReturnOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategy(operationHandlerMap);
        List<String> inputData = readFile.getDataFromFile(INPUT_FILE_PATH);
        OperationParser operationParser = new OperationParserImpl();
        List<TransactionDto> operations = operationParser.parseOperations(inputData);
        FruitService fruitService;
        fruitService = new FruitServiceImpl(operationStrategy);
        fruitService.saveFruitByOperation(operations);
        DailyReportService dailyReportService = new DailyReportServiceImpl();
        String report = dailyReportService.createReport();
        ReportWriter reportWriter = new ReportWriterImpl();
        reportWriter.writeReport(OUTPUT_FILE_PATH, report);
    }
}

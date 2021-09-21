import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Operation;
import service.AmountCalculator;
import service.AmountCalculatorImpl;
import service.OperationStrategy;
import service.OperationStrategyImpl;
import service.ReportService;
import service.ReportServiceImpl;
import service.data.CsvOperationParser;
import service.data.DataParser;
import service.file.ReaderService;
import service.file.ReaderServiceImpl;
import service.file.WriterService;
import service.file.WriterServiceImpl;
import service.operation.DecreaseOperationHandler;
import service.operation.IncreaseOperationHandler;
import service.operation.OperationHandler;

public class Main {
    private static final String FROM_FILE = "src/main/resources/input.csv";
    private static final String TO_FILE = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Map<Operation.Type, OperationHandler> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.Type.BALANCE, new IncreaseOperationHandler());
        operationStrategyMap.put(Operation.Type.PURCHASE, new DecreaseOperationHandler());
        operationStrategyMap.put(Operation.Type.RETURN, new IncreaseOperationHandler());
        operationStrategyMap.put(Operation.Type.SUPPLY, new IncreaseOperationHandler());
        ReaderService readerService = new ReaderServiceImpl();
        List<String> dataFromFile = readerService.readFromFile(FROM_FILE);
        DataParser<Operation, String> dataParser = new CsvOperationParser();
        List<Operation> operations = dataParser.formatData(dataFromFile);
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationStrategyMap);
        AmountCalculator amountCalculator = new AmountCalculatorImpl(operationStrategy);
        Map<String, Integer> calculateFruits = amountCalculator.calculateDataForReport(operations);
        ReportService reportService = new ReportServiceImpl();
        WriterService writerService = new WriterServiceImpl();
        writerService.write(TO_FILE, reportService.createReport(calculateFruits));
    }
}

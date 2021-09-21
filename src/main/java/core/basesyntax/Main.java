package core.basesyntax;

import core.basesyntax.dao.DataReader;
import core.basesyntax.dao.DataReaderImpl;
import core.basesyntax.dao.DataWriter;
import core.basesyntax.dao.DataWriterImpl;
import core.basesyntax.dao.ReportService;
import core.basesyntax.dao.ReportServiceImpl;
import core.basesyntax.model.Operation;
import core.basesyntax.services.calculation.AmountCalculator;
import core.basesyntax.services.calculation.AmountCalculatorImpl;
import core.basesyntax.services.data.DataParser;
import core.basesyntax.services.data.ParserCsv;
import core.basesyntax.services.operation.DecreaseHandler;
import core.basesyntax.services.operation.Handler;
import core.basesyntax.services.operation.IncreaseHandler;
import core.basesyntax.services.operation.Strategy;
import core.basesyntax.services.operation.StrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Map<Operation.Type, Handler> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.Type.BALANCE, new IncreaseHandler());
        operationStrategyMap.put(Operation.Type.PURCHASE, new DecreaseHandler());
        operationStrategyMap.put(Operation.Type.RETURN, new IncreaseHandler());
        operationStrategyMap.put(Operation.Type.SUPPLY, new IncreaseHandler());
        DataReader readerService = new DataReaderImpl();
        List<String> dataFromFile = readerService.readFromFile(INPUT_FILE);
        DataParser<Operation, String> dataParser = new ParserCsv();
        List<Operation> operations = dataParser.formatData(dataFromFile);
        Strategy strategy = new StrategyImpl(operationStrategyMap);
        AmountCalculator amountCalculator = new AmountCalculatorImpl(strategy);
        Map<String, Integer> calculateFruits = amountCalculator.calculateDataForReport(operations);
        ReportService reportService = new ReportServiceImpl();
        DataWriter dataWriter = new DataWriterImpl();
        dataWriter.write(OUTPUT_FILE, reportService.createReport(calculateFruits));
    }
}

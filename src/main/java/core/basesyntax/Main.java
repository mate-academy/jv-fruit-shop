package core.basesyntax;

import core.basesyntax.dao.FileReader;
import core.basesyntax.dao.FileReaderImpl;
import core.basesyntax.dao.FileWriter;
import core.basesyntax.dao.FileWriterImpl;
import core.basesyntax.dao.ReportService;
import core.basesyntax.dao.ReportServiceImpl;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.services.calculation.AmountCalculator;
import core.basesyntax.services.calculation.AmountCalculatorImpl;
import core.basesyntax.services.data.DataParser;
import core.basesyntax.services.data.ParserCsv;
import core.basesyntax.services.operation.DecreaseOperationHandler;
import core.basesyntax.services.operation.IncreaseOperationHandler;
import core.basesyntax.services.operation.OperationHandler;
import core.basesyntax.services.operation.Strategy;
import core.basesyntax.services.operation.StrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Map<TransactionDto.Type, OperationHandler> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(TransactionDto.Type.BALANCE, new IncreaseOperationHandler());
        operationStrategyMap.put(TransactionDto.Type.PURCHASE, new DecreaseOperationHandler());
        operationStrategyMap.put(TransactionDto.Type.RETURN, new IncreaseOperationHandler());
        operationStrategyMap.put(TransactionDto.Type.SUPPLY, new IncreaseOperationHandler());
        FileReader readerService = new FileReaderImpl();
        List<String> dataFromFile = readerService.read(INPUT_FILE);
        DataParser<TransactionDto, String> dataParser = new ParserCsv();
        List<TransactionDto> transactionDtos = dataParser.formatData(dataFromFile);
        Strategy strategy = new StrategyImpl(operationStrategyMap);
        AmountCalculator amountCalculator = new AmountCalculatorImpl(strategy);
        Map<String, Integer> calculateFruits =
                amountCalculator.calculateDataForReport(transactionDtos);
        ReportService reportService = new ReportServiceImpl();
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(OUTPUT_FILE, reportService.createReport(calculateFruits));
    }
}

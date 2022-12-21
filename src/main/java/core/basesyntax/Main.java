package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.strategy.filestrategy.DataParser;
import core.basesyntax.strategy.filestrategy.DataParsingStrategy;
import core.basesyntax.strategy.filestrategy.FileType;
import core.basesyntax.strategy.filestrategy.ReportBuilder;
import core.basesyntax.strategy.filestrategy.ReportBuilderStrategy;
import core.basesyntax.strategy.filestrategy.impl.CsvDataParserImpl;
import core.basesyntax.strategy.filestrategy.impl.CsvReportBuilderImpl;
import core.basesyntax.strategy.operationstrategy.OperationCalculator;
import core.basesyntax.strategy.operationstrategy.OperationStrategy;
import core.basesyntax.strategy.operationstrategy.impl.BalanceOperationCalculatorImpl;
import core.basesyntax.strategy.operationstrategy.impl.PurchaseOperationCalculatorImpl;
import core.basesyntax.strategy.operationstrategy.impl.ReturnOperationCalculatorImpl;
import core.basesyntax.strategy.operationstrategy.impl.SupplyOperationCalculatorImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final FileReaderService fileReaderService = new FileReaderServiceImpl();
    private static final FileWriterService fileWriterService = new FileWriterServiceImpl();
    private static final Map<FruitTransaction.Operation, OperationCalculator>
            operationCalculatorsMap = new HashMap<>();
    private static final Map<String, ReportBuilder>
            reportBuildersMap = new HashMap<>();
    private static final Map<String, DataParser>
            dataParsersMap = new HashMap<>();
    private static final OperationStrategy
            operationStrategy = new OperationStrategy(operationCalculatorsMap);
    private static final DataParsingStrategy
            parsingStrategy = new DataParsingStrategy(dataParsersMap);
    private static final ReportBuilderStrategy reportStrategy
            = new ReportBuilderStrategy(reportBuildersMap);
    private static DataParser dataParser;
    private static ReportBuilder reportBuilder;
    private static final String INPUT_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_PATH = "src/main/resources/report.csv";

    static {
        operationCalculatorsMap.put(
                FruitTransaction.Operation.BALANCE, new BalanceOperationCalculatorImpl());
        operationCalculatorsMap.put(
                FruitTransaction.Operation.SUPPLY, new SupplyOperationCalculatorImpl());
        operationCalculatorsMap.put(
                FruitTransaction.Operation.PURCHASE, new PurchaseOperationCalculatorImpl());
        operationCalculatorsMap.put(
                FruitTransaction.Operation.RETURN, new ReturnOperationCalculatorImpl());
        reportBuildersMap.put(FileType.CSV.getName(), new CsvReportBuilderImpl(operationStrategy));
        dataParsersMap.put(FileType.CSV.getName(), new CsvDataParserImpl());
    }

    public static void main(String[] args) {
        dataParser = parsingStrategy.getDataParser("csv");
        reportBuilder = reportStrategy.getReportBuilder("csv");
        String data = fileReaderService.readFromFile(INPUT_PATH);
        List<FruitTransaction> transactions = dataParser.parseData(data);
        String report = reportBuilder.buildReport(transactions);
        fileWriterService.writeToFile(OUTPUT_PATH, report);
    }
}

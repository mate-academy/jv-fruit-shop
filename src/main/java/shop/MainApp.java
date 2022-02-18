package shop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import shop.impl.FruitTransaction;
import shop.service.*;
import shop.strategy.AddOperationHandler;
import shop.strategy.BalanceOperationHandler;
import shop.strategy.OperationHandler;
import shop.strategy.Strategy;
import shop.strategy.SubtractOperationHandler;

public class MainApp {
    public static final String BALANCE = "b";
    public static final String SUPPLY = "s";
    public static final String RETURN = "r";
    public static final String PURCHASE = "p";
    private static final String INPUT_FILE = "src/main/java/resources/input.csv";
    private static final String OUTPUT_FILE = "src/main/java/resources/report.csv";
    private static final Map<String, OperationHandler> operationsData = new HashMap<>();

    static {
        operationsData.put(BALANCE, new BalanceOperationHandler());
        operationsData.put(SUPPLY, new AddOperationHandler());
        operationsData.put(RETURN, new AddOperationHandler());
        operationsData.put(PURCHASE, new SubtractOperationHandler());
    }

    public static void main(String[] args) {
        FileReaderService fileReader = new FileReaderServiceImpl();
        List<String> linesFromFile = fileReader.read(INPUT_FILE);
        List<FruitTransaction> fruitTransactionList;
        RowParser rowParser = new RowParserImpl();
        fruitTransactionList = IntStream
                .range(1, linesFromFile.size())
                .mapToObj(i -> rowParser.parseLine(linesFromFile.get(i)))
                .collect(Collectors.toList());
        Strategy strategy = new Strategy(operationsData);
        strategy.performOperation(fruitTransactionList);
        ReportWriter reportWriter = new ReportWriterImpl();
        String report = reportWriter.makeReport();
        FileWriterService fileWriter = new FileWriterServiceImpl();
        fileWriter.write(OUTPUT_FILE, report);
    }
}

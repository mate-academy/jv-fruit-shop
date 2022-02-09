package shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import shop.impl.FruitTransaction;
import shop.service.FileService;
import shop.service.FileServiceImpl;
import shop.service.RowParser;
import shop.service.RowParserImpl;
import shop.service.ReportWriter;
import shop.service.ReportWriterImpl;
import shop.strategy.BalanceOperationHandler;
import shop.strategy.OperationHandler;
import shop.strategy.SubtractOperationHandler;
import shop.strategy.AddOperationHandler;
import shop.strategy.Strategy;

public class MainApp {
    public static final String BALANCE = "b";
    public static final String SUPPLY = "s";
    public static final String RETURN = "r";
    public static final String PURCHASE = "p";
    private static final String INPUT_FILE = "src/main/java/resources/input.csv";
    private static final String OUTPUT_FILE = "src/main/java/resources/report.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> operationsData = new HashMap<>();
        operationsData.put(BALANCE, new BalanceOperationHandler());
        operationsData.put(SUPPLY, new AddOperationHandler());
        operationsData.put(RETURN, new AddOperationHandler());
        operationsData.put(PURCHASE, new SubtractOperationHandler());
        FileService fileReader = new FileServiceImpl();
        List<String> linesFromFile = fileReader.read(INPUT_FILE);
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        RowParser rowParser = new RowParserImpl();
        for (int i = 1; i < linesFromFile.size(); i++) {
            fruitTransactionList.add(rowParser.parseLine(linesFromFile.get(i)));
        }
        Strategy strategy = new Strategy(operationsData);
        strategy.performOperation(fruitTransactionList);
        ReportWriter reportWriter = new ReportWriterImpl();
        String report = reportWriter.makeReport();
        FileServiceImpl fileWriter = new FileServiceImpl();
        fileWriter.write(OUTPUT_FILE, report);
    }
}

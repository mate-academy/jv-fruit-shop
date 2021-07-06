package core;

import dto.ShopOperation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import service.FileReader;
import service.FileReaderImpl;
import service.FileWriter;
import service.FileWriterImpl;
import service.Parser;
import service.ParserImpl;
import service.ReportService;
import service.ReportServiceImpl;
import strategy.AddOperationHandler;
import strategy.BalanceOperationHandler;
import strategy.OperationHandler;
import strategy.Strategy;
import strategy.SubtractOperationHandler;

public class Main {
    public static final String BALANCE = "b";
    public static final String SUPPLY = "s";
    public static final String RETURN = "r";
    public static final String PURCHASE = "p";
    private static final String INPUT_FILE_NAME = "src/main/resources/shop_operations.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> handlers = new HashMap<>();
        handlers.put(BALANCE, new BalanceOperationHandler());
        handlers.put(SUPPLY, new AddOperationHandler());
        handlers.put(RETURN, new AddOperationHandler());
        handlers.put(PURCHASE, new SubtractOperationHandler());

        FileReader reader = new FileReaderImpl();
        List<String> linesFromFile = reader.read(INPUT_FILE_NAME);

        List<ShopOperation> shopOperationList = new ArrayList<>();
        Parser parser = new ParserImpl();
        for (int i = 1; i < linesFromFile.size(); i++) {
            shopOperationList.add(parser.parseLine(linesFromFile.get(i)));
        }

        Strategy strategy = new Strategy(handlers);
        strategy.performOperation(shopOperationList);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.makeReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(OUTPUT_FILE_NAME, report);
    }
}

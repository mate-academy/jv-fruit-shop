package core.basesyntax;

import database.FileService;
import database.FileServiceImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import service.LineParser;
import service.LineParserImpl;
import service.ReportService;
import service.ReportServiceImpl;
import shop.FruitShopOperation;
import shop.Operation;
import strategy.BalanceHandler;
import strategy.PurchaseHandler;
import strategy.ReturnHandler;
import strategy.Strategy;
import strategy.SupplyHandler;
import strategy.TypeHandler;

public class Main {

    private static final String inputName = "src/main/java/database/inputValue.csv";
    private static final String outPutName = "src/main/java/database/outPutValue.csv";

    public static void main(String[] args) {

        Map<String, TypeHandler> typeHandlerMap = new HashMap<>();
        typeHandlerMap.put(Operation.BALANCE.getType(), new BalanceHandler());
        typeHandlerMap.put(Operation.RETURN.getType(), new ReturnHandler());
        typeHandlerMap.put(Operation.SUPPLY.getType(), new SupplyHandler());
        typeHandlerMap.put(Operation.PURCHASE.getType(), new PurchaseHandler());

        FileService fruitDao = new FileServiceImpl();
        List<String> input = fruitDao.readFile(inputName);

        List<FruitShopOperation> shopOperationList = new ArrayList<>();
        LineParser parser = new LineParserImpl();
        for (int i = 1; i < input.size(); i++) {
            shopOperationList.add(parser.parseLine(input.get(i)));

        }
        Strategy strategy = new Strategy(typeHandlerMap);
        strategy.operationHandler(shopOperationList);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.makeReport();

        FileService fileWriter = new FileServiceImpl();
        fileWriter.writeToFile(outPutName, report);
    }
}

import dto.TransferObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import service.FruitParser;
import service.FruitReadFile;
import service.FruitReportService;
import service.FruitWriteFile;
import service.Operations;
import strategy.BalanceOperationHandler;
import strategy.OperationHandler;
import strategy.PurchaseOperationHandler;
import strategy.SupplyOperationHandler;

public class Main {
    public static void main(String[] args) {
        Map<Operations, OperationHandler> handlerMap = new HashMap<>();
        handlerMap.put(Operations.b, new BalanceOperationHandler());
        handlerMap.put(Operations.s, new SupplyOperationHandler());
        handlerMap.put(Operations.p, new PurchaseOperationHandler());
        handlerMap.put(Operations.r, new SupplyOperationHandler());

        List<String> parsedLines = new FruitReadFile()
                .readLines("src/main/resources/shop_operations.csv");
        parsedLines.remove(0);
        List<TransferObject> listOfTransferObjects = new ArrayList<>();
        FruitParser fruitParser = new FruitParser();
        for (String line : parsedLines) {
            listOfTransferObjects.add(fruitParser.parse(line));
        }
        for (TransferObject transferObject : listOfTransferObjects) {
            OperationHandler handler =
                    handlerMap.get(Operations.valueOf(transferObject.getOperation()));
            handler.perform(transferObject);
        }
        FruitReportService reportService = new FruitReportService();
        String report = reportService.getReport();
        FruitWriteFile writeFile = new FruitWriteFile();
        writeFile.writeLines("src/main/resources/report.csv", report);
    }
}

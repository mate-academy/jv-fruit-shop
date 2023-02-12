import dao.FruitParser;
import dao.ShopParser;
import dao.impl.FruitParserImpl;
import dao.impl.ShopParserImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FileReaderService;
import service.FileWriterService;
import service.FruitShopService;
import service.ReportService;
import service.impl.FileReaderServiceImpl;
import service.impl.FileWriterServiceImpl;
import service.impl.FruitShopServiceImpl;
import service.impl.ReportServiceImpl;
import strategy.GeneralOperation;
import strategy.impl.BalanceHandler;
import strategy.impl.PurchaseHandler;
import strategy.impl.ReturnHandler;
import strategy.impl.SupplyHandler;

public class MainFruitShop {
    private static final String INPUT_PATH = "src/main/resources/InputFile.csv";
    private static final String REPORT_PATH = "src/main/resources/ReportFile.csv";

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        String dataFromFile = fileReaderService.readFile(INPUT_PATH);

        ShopParser shopParser = new ShopParserImpl();
        String[] parsedData = shopParser.parse(dataFromFile);

        Map<FruitTransaction.Operation, GeneralOperation> operationHandlersMap = new HashMap<>();
        operationHandlersMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationHandlersMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        operationHandlersMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlersMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());

        FruitParser parseFruit = new FruitParserImpl();
        List<FruitTransaction> fruitTransactions = parseFruit.parse(parsedData);

        FruitShopService fruitShopService = new FruitShopServiceImpl(operationHandlersMap);
        fruitShopService.transfer(fruitTransactions);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.getReport();

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(report, REPORT_PATH);
        System.out.println(fileReaderService.readFile(REPORT_PATH));
    }
}

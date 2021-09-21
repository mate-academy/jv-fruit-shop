import dao.FileReaderDao;
import dao.FileReaderDaoImpl;
import dao.FileWriterDao;
import dao.FileWriterDaoImpl;
import model.Fruit;
import model.FruitRecord;
import model.TypeOperation;
import service.FruitShopService;
import service.FruitShopServiceImpl;
import service.OperationStrategy;
import service.OperationStrategyImpl;
import service.ReportService;
import service.ReportServiceImpl;
import service.operation.BalanceHandlerImpl;
import service.operation.FruitParser;
import service.operation.Handler;
import service.operation.PurchaseHandlerImpl;
import service.operation.ReturnHandlerImpl;
import service.operation.SupplyHandlerImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String INPUT = "src/main/resources/input.csv";
    public static final String OUTPUT = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FileReaderDao fileReaderDao = new FileReaderDaoImpl();
        Handler balanceHandler = new BalanceHandlerImpl();
        Handler purchaseHandler = new PurchaseHandlerImpl();
        Handler supplyHandler = new SupplyHandlerImpl();
        Handler returnHandler = new ReturnHandlerImpl();
        Map<String, Handler> handlerMap = new HashMap<>();
        handlerMap.put(TypeOperation.b.name(), balanceHandler);
        handlerMap.put(TypeOperation.s.name(), supplyHandler);
        handlerMap.put(TypeOperation.p.name(), purchaseHandler);
        handlerMap.put(TypeOperation.r.name(), returnHandler);
        FruitParser fruitParser = new FruitParser();
        List<String> input = fileReaderDao.getDataFile(INPUT);
        List<FruitRecord> fruitRecordList = fruitParser.createDto(input);
        OperationStrategy operationStrategy = new OperationStrategyImpl(handlerMap);
        FruitShopService fruitShopService = new FruitShopServiceImpl(operationStrategy);
        Map<Fruit, Integer> reportMap = fruitShopService.transfer(fruitRecordList, operationStrategy);
        ReportService reportService = new ReportServiceImpl();
        FileWriterDao fileWriter = new FileWriterDaoImpl();
        fileWriter.writeFile(OUTPUT, reportService.createReport(reportMap));
    }
}
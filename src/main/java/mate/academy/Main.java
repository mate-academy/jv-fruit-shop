package mate.academy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mate.academy.dao.FruitDao;
import mate.academy.dao.FruitDaoImpl;
import mate.academy.model.Fruit;
import mate.academy.operation.OperationHandler;
import mate.academy.operation.impl.BalanceHandler;
import mate.academy.operation.impl.PurchaseHandler;
import mate.academy.operation.impl.ReturnHandler;
import mate.academy.operation.impl.SupplyHandler;
import mate.academy.service.ParseService;
import mate.academy.service.ReaderService;
import mate.academy.service.ReportService;
import mate.academy.service.WriterService;
import mate.academy.service.impl.ParseServiceImpl;
import mate.academy.service.impl.ReaderServiceImpl;
import mate.academy.service.impl.ReportServiceImpl;
import mate.academy.service.impl.WriterServiceImpl;
import mate.academy.strategy.OperationStrategy;
import mate.academy.strategy.impl.OperationStrategyImpl;

public class Main {
    public static void main(String[] args) {
        //System.out.println(new ReaderServiceImpl().readFromFile("src/main/resources/file.csv"));
        Map<Fruit.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Fruit.Operation.BALANCE, new BalanceHandler());
        operationHandlerMap.put(Fruit.Operation.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(Fruit.Operation.SUPPLY, new SupplyHandler());
        operationHandlerMap.put(Fruit.Operation.RETURN, new ReturnHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        ReaderService readerService = new ReaderServiceImpl();
        ParseService parseService = new ParseServiceImpl();

        List<String> stringsFromFile = readerService.readFromFile("src/main/resources/file.csv");
        List<Fruit> fruits = parseService.parseString(stringsFromFile);

        for (Fruit fruit : fruits) {
            operationStrategy.get(fruit.getOperation()).getHandler(fruit);
        }

        WriterService writerService = new WriterServiceImpl();
        FruitDao fruitDao = new FruitDaoImpl();
        ReportService reportService = new ReportServiceImpl();
        writerService.writeToFile("src/main/resources/report.csv",
                 reportService.getReport(fruitDao.getList()));

        /* for (Map.Entry<String, FruitTransaction> entry : Storage.fruits.entrySet()) {
            System.out.println(entry.getValue().getFruit() + " " + entry.getValue().getQuantity());
        }*/

    }
}

import dao.Fruit;
import dao.FruitDao;
import dao.FruitDaoImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.TransactionDto;
import service.Parser;
import service.impl.CreateReportImpl;
import service.impl.FileReaderImpl;
import service.impl.FileWriterImpl;
import service.impl.FruitServiceImpl;
import service.impl.ParserImpl;
import service.impl.ValidatorServiceImpl;
import strategy.Operation;
import strategy.OperationHandler;
import strategy.OperationStrategy;
import strategy.impl.AddOperationImpl;
import strategy.impl.BalanceOperationImpl;
import strategy.impl.OperationStrategyImpl;
import strategy.impl.PurchaseOperationImpl;

public class Main {
    private static final String TEST_FILE_PATH = "src/main/resources/testFile.csv";
    private static final String REPORT_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        Map<Operation, OperationHandler> activityHandlerMap = new HashMap<>();
        activityHandlerMap.put(Operation.BALANCE, new BalanceOperationImpl(fruitDao));
        activityHandlerMap.put(Operation.PURCHASE, new PurchaseOperationImpl(fruitDao));
        activityHandlerMap.put(Operation.RETURN, new AddOperationImpl(fruitDao));
        activityHandlerMap.put(Operation.SUPPLY, new AddOperationImpl(fruitDao));
        List<String> text = new FileReaderImpl().readFromFile(TEST_FILE_PATH);
        new ValidatorServiceImpl().validate(text);
        OperationStrategy activitiesStrategy = new OperationStrategyImpl(activityHandlerMap);
        List<TransactionDto> transactions = new ArrayList<>();
        Parser parser = new ParserImpl();
        for (int i = 1; i < text.size(); i++) {
            transactions.add(parser.parseLine(text.get(i)));
        }
        List<Fruit> fruits = new FruitServiceImpl(fruitDao, activitiesStrategy)
                .changeBalance(transactions);
        String report = new CreateReportImpl().createReport();
        new FileWriterImpl().writeData(REPORT_PATH, report);
    }
}

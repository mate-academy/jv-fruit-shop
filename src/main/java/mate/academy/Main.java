package mate.academy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mate.academy.dao.FruitDao;
import mate.academy.dao.FruitDaoImpl;
import mate.academy.model.FruitTransaction;
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
    private static final String INPUT_FILE_PATH = "src/main/resources/file.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler(fruitDao));
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler(fruitDao));
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler(fruitDao));
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler(fruitDao));

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        ReaderService readerService = new ReaderServiceImpl();
        ParseService parseService = new ParseServiceImpl();

        List<String> stringsFromFile = readerService.readFromFile(INPUT_FILE_PATH);
        List<FruitTransaction> fruitTransactions = parseService.parse(stringsFromFile);

        for (FruitTransaction fruitTransaction : fruitTransactions) {
            operationStrategy.process(fruitTransaction.getOperation()).getHandler(fruitTransaction);
        }

        WriterService writerService = new WriterServiceImpl();
        ReportService reportService = new ReportServiceImpl();
        writerService.writeToFile(REPORT_FILE_PATH,
                 reportService.getReport(fruitDao.getAll()));
    }
}

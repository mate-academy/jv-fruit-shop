package core.basesyntax;

import dao.FruitDao;
import dao.FruitDaoImpl;
import java.util.Map;
import model.FruitTransaction;
import service.FruitTransactionMapper;
import service.FruitTransactionService;
import service.Reader;
import service.ReportCreator;
import service.Writer;
import service.impl.FileReaderImpl;
import service.impl.FruitTransactionMapperImpl;
import service.impl.FruitTransactionServiceImpl;
import service.impl.ReportCreatorImpl;
import service.impl.WriterImpl;
import service.operation.BalanceOperationHandler;
import service.operation.OperationHandler;
import service.operation.PurchaseOperationHandler;
import service.operation.ReturnOperationHandler;
import service.operation.SupplyOperationHandler;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;

public class Main {
    private static final String FRUIT_SHOP_FILE_NAME = "src\\main\\resources\\During the day.csv";
    private static final String REPORT_FILE_NAME = "src\\main\\resources\\Report file.csv";

    public static void main(String[] args) {
        FruitDao dao = new FruitDaoImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(),
                FruitTransaction.Operation.RETURN, new ReturnOperationHandler(),
                FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler()
        );
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        Reader reader = new FileReaderImpl();
        String fileData = reader.readFile(FRUIT_SHOP_FILE_NAME);

        FruitTransactionMapper converter = new FruitTransactionMapperImpl();
        FruitTransaction[] fruitTransactions = converter.buildFruitTransactions(fileData);

        FruitTransactionService fruitTransactionService =
                new FruitTransactionServiceImpl(dao, operationStrategy);
        fruitTransactionService.processData(fruitTransactions);

        ReportCreator creator = new ReportCreatorImpl();
        String report = creator.createReport();

        Writer writer = new WriterImpl();
        writer.write(report, REPORT_FILE_NAME);
    }
}

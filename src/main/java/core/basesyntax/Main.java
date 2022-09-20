package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FruitService;
import service.FruitServiceImpl;
import service.parsefruitransaction.ParseFruitTransaction;
import service.parsefruitransaction.ParseFruitTransactionImpl;
import service.writereadcsv.FileReader;
import service.writereadcsv.FileReaderImp;
import service.writereadcsv.FileWriter;
import service.writereadcsv.FileWriterImpl;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;
import strategy.operationhandlers.BalanceOperationHandlerImpl;
import strategy.operationhandlers.OperationHandler;
import strategy.operationhandlers.PurchaseOperationHandlerImpl;
import strategy.operationhandlers.ReturnOperationHandlerImpl;
import strategy.operationhandlers.SupplyOperationHandlerImpl;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    private static final String FILE_TO_WRITE = "src/main/resources/outputdate/report.csv";
    private static final String FILE_TO_READ = "src/main/resources/input/fruit.csv";

    public static void main(String[] args) {
        OperationHandler balance = new BalanceOperationHandlerImpl();
        OperationHandler supply = new SupplyOperationHandlerImpl();
        OperationHandler retur = new ReturnOperationHandlerImpl();
        OperationHandler purchase = new PurchaseOperationHandlerImpl();
        Map<FruitTransaction.Operation, OperationHandler> map = new HashMap<>();
        FileReader readCsv = new FileReaderImp();
        ParseFruitTransaction parse = new ParseFruitTransactionImpl();
        map.put(FruitTransaction.Operation.BALANCE,balance);
        map.put(FruitTransaction.Operation.SUPPLY,supply);
        map.put(FruitTransaction.Operation.RETURN,retur);
        map.put(FruitTransaction.Operation.PURCHASE,purchase);
        FileWriter fruitWriterCsv = new FileWriterImpl();
        List<String> readFromFileCsv = readCsv.readFromFileCsv(FILE_TO_READ);
        List<FruitTransaction> list = parse.parseToFruitTransactions(readFromFileCsv);
        OperationStrategy strategy = new OperationStrategyImpl(map);
        FruitService fruitService = new FruitServiceImpl(strategy);
        String report = fruitService.getReport(list);
        fruitWriterCsv.writeToFileCsv(report, FILE_TO_WRITE);
    }
}

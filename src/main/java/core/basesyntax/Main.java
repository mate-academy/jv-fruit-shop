package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FruitService;
import service.FruitServiceImpl;
import service.parsefruitransaction.ParseFruitTransaction;
import service.parsefruitransaction.ParseFruitTransactionImpl;
import service.writereadcsv.FruitServiceReaderCsv;
import service.writereadcsv.FruitServiceReaderCsvImp;
import service.writereadcsv.FruitServiceWriterCsv;
import service.writereadcsv.FruitServiceWriterCsvImpl;
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
    private static String fileToWrite = "src/main/resources/outputdate/report.csv";
    private static String fileToRead = "src/main/resources/input/fruit.csv";
    private static OperationHandler balance = new BalanceOperationHandlerImpl();
    private static OperationHandler supply = new SupplyOperationHandlerImpl();
    private static OperationHandler retur = new ReturnOperationHandlerImpl();
    private static OperationHandler purchase = new PurchaseOperationHandlerImpl();
    private static Map<FruitTransaction.Operation, OperationHandler> map = new HashMap<>();
    private static FruitServiceReaderCsv readCsv = new FruitServiceReaderCsvImp();
    private static ParseFruitTransaction parse = new ParseFruitTransactionImpl();
    private static FruitServiceWriterCsv fruitWriterCsv = new FruitServiceWriterCsvImpl();

    public static void main(String[] args) {
        map.put(FruitTransaction.Operation.BALANCE,balance);
        map.put(FruitTransaction.Operation.SUPPLY,supply);
        map.put(FruitTransaction.Operation.RETURN,retur);
        map.put(FruitTransaction.Operation.PURCHASE,purchase);
        List<String> readFromFileCsv = readCsv.readFromFileCsv(fileToRead);
        List<FruitTransaction> list = parse.getParseFruitTransaction(readFromFileCsv);
        OperationStrategy strategy = new OperationStrategyImpl(map);
        FruitService fruitService = new FruitServiceImpl(strategy);
        List<FruitTransaction> reportFruitBalance = fruitService.getReport(list);
        fruitWriterCsv.writeToFileCsv(reportFruitBalance,fileToWrite);
    }
}

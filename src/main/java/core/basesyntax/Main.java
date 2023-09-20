package core.basesyntax;

import core.basesyntax.filework.FileReader;
import core.basesyntax.filework.FileWriteServiceImpl;
import core.basesyntax.filework.ReportCreatorService;
import core.basesyntax.handler.BalanceTransaction;
import core.basesyntax.handler.PurchaseTransaction;
import core.basesyntax.handler.ReturnTransaction;
import core.basesyntax.handler.SupplyTransaction;
import core.basesyntax.handler.TransactionHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Transaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String DATA_FILE_PATH =
            "src/main/java/core/basesyntax/resourses/DataFile.cvs";
    private static final String REPORT_FILE_PATH =
            "src/main/java/core/basesyntax/resourses/ReportFile.cvs";

    public static void main(String[] args) {
        FileReader readerService = new FileReader();
        DataStorage dataConverterService = new DataStorage();
        ProccessService proccessService = new ProccessService(getOperationMap());
        ReportCreatorService reportCreatorService = new ReportCreatorServiceImpl();
        FileWriteServiceImpl fileWriteService = new FileWriteServiceImpl();
        List<String> strings = readerService.readFromFile(DATA_FILE_PATH);
        List<FruitTransaction> fruitTransactions = dataConverterService.convertText(strings);
        proccessService.proccessing(fruitTransactions);
        String reportString = reportCreatorService.createReport();
        fileWriteService.writeToFile(reportString, REPORT_FILE_PATH);
    }

    private static Map<Transaction, TransactionHandler> getOperationMap() {
        Map<Transaction, TransactionHandler> operationMap = new HashMap<>();
        operationMap.put(Transaction.BALANCE, new BalanceTransaction());
        operationMap.put(Transaction.RETURN, new ReturnTransaction());
        operationMap.put(Transaction.PURCHASE, new PurchaseTransaction());
        operationMap.put(Transaction.SUPPLY, new SupplyTransaction());
        return operationMap;
    }
}

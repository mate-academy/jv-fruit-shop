package core.basesyntax;

import core.basesyntax.dao.BalanceOperationHandlerImpl;
import core.basesyntax.dao.OperationHandler;
import core.basesyntax.dao.PurchaseOperationHandlerImpl;
import core.basesyntax.dao.ReturnOperationHandlerImpl;
import core.basesyntax.dao.SupplyOperationHandlerImpl;
import core.basesyntax.models.FruitTransaction;
import core.basesyntax.service.CreateReport;
import core.basesyntax.service.PopulatingDbService;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.WorkWithFiles;
import core.basesyntax.service.impl.CreateReportImpl;
import core.basesyntax.service.impl.PopulatingDbServiceImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.service.impl.WorkWithCsvFile;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String BALANCE = "b";
    public static final String SUPPLY = "s";
    public static final String RETURN = "r";
    public static final String PURCHASE = "p";
    private static final Map<String, OperationHandler> operationTypes = new HashMap<>();
    private static final String INPUT_FILE_NAME = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/resources/report.csv";

    public static void main(String[] args) {
        operationTypes.put(BALANCE, new BalanceOperationHandlerImpl());
        operationTypes.put(SUPPLY, new SupplyOperationHandlerImpl());
        operationTypes.put(RETURN, new ReturnOperationHandlerImpl());
        operationTypes.put(PURCHASE, new PurchaseOperationHandlerImpl());
        WorkWithFiles fileWorker = new WorkWithCsvFile();
        List<String> inputData = fileWorker.readFromFile(INPUT_FILE_NAME);
        TransactionService transactionService = new TransactionServiceImpl();
        List<FruitTransaction> transactionList = transactionService
                .createTransactionsList(inputData);
        PopulatingDbService populatingDB = new PopulatingDbServiceImpl(operationTypes);
        populatingDB.prepareDB(transactionList);
        CreateReport report = new CreateReportImpl();
        fileWorker.writeToFile(OUTPUT_FILE_NAME, report.createReport());
    }
}

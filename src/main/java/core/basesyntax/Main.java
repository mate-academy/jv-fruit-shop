package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.impl.DataProcessingServiceImpl;
import core.basesyntax.impl.InputDataServiceImpl;
import core.basesyntax.impl.ReadCsvServiceImpl;
import core.basesyntax.impl.ReportGeneratingServiceImpl;
import core.basesyntax.impl.TransactionStrategyImpl;
import core.basesyntax.impl.WriteReportServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataProcessingService;
import core.basesyntax.service.InputDataService;
import core.basesyntax.service.ReadCsvService;
import core.basesyntax.service.ReportGeneratingService;
import core.basesyntax.service.WriteReportService;
import core.basesyntax.strategy.TransactionStrategy;
import core.basesyntax.strategy.transaction.BalanceTransactionHandler;
import core.basesyntax.strategy.transaction.PurchaseTransactionHandler;
import core.basesyntax.strategy.transaction.ReturnTransactionHandler;
import core.basesyntax.strategy.transaction.SupplyTransactionHandler;
import core.basesyntax.strategy.transaction.TransactionHandler;
import java.util.List;
import java.util.Map;

public class Main {
    public static final ReadCsvService READ_CSV_SERVICE = new ReadCsvServiceImpl();
    public static final InputDataService INPUT_DATA_SERVICE = new InputDataServiceImpl();
    public static final ReportGeneratingService REPORT_GENERATING_SERVICE =
            new ReportGeneratingServiceImpl();
    public static final Map<FruitTransaction.Operation, TransactionHandler>
            TRANSACTION_HANDLER_MAP =
                Map.of(FruitTransaction.Operation.BALANCE, new BalanceTransactionHandler(),
                        FruitTransaction.Operation.SUPPLY, new SupplyTransactionHandler(),
                        FruitTransaction.Operation.PURCHASE, new PurchaseTransactionHandler(),
                        FruitTransaction.Operation.RETURN, new ReturnTransactionHandler());
    public static final WriteReportService WRITE_REPORT_SERVICE = new WriteReportServiceImpl();
    public static final FruitDao FRUIT_DAO = new FruitDaoImpl();
    public static final String INPUT_PATH = "src/main/resources/inputData.csv";
    public static final String OUTPUT_PATH = "src/main/resources/dayReport.csv";

    public static void main(String[] args) {
        FRUIT_DAO.add("banana");
        FRUIT_DAO.add("apple");

        List<String> dataCsv = READ_CSV_SERVICE.readFromFile(INPUT_PATH);

        List<FruitTransaction> fruitTransactions = INPUT_DATA_SERVICE.convertDataToObj(dataCsv);

        TransactionStrategy transactionStrategy =
                new TransactionStrategyImpl(TRANSACTION_HANDLER_MAP);

        DataProcessingService dataProcessingService =
                new DataProcessingServiceImpl(FRUIT_DAO, transactionStrategy);
        dataProcessingService.updateDataStorage(fruitTransactions);

        String report = REPORT_GENERATING_SERVICE.generateReportViaStorage();

        WRITE_REPORT_SERVICE.writeReport(report, OUTPUT_PATH);
    }
}

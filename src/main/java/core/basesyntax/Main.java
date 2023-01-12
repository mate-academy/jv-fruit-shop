package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataReader;
import core.basesyntax.service.DataWriter;
import core.basesyntax.service.GetListOfTransactions;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.StorageUpdateService;
import core.basesyntax.service.amount.BalanceHandlerImpl;
import core.basesyntax.service.amount.OperationHandler;
import core.basesyntax.service.amount.PurchaseHandlerImpl;
import core.basesyntax.service.amount.SupplyHandlerImpl;
import core.basesyntax.service.impl.DataReaderImpl;
import core.basesyntax.service.impl.DataWriterImpl;
import core.basesyntax.service.impl.GetListOfTransactionsImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.StorageUpdateServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final DataReader DATA_READER = new DataReaderImpl();
    private static final Map<Operation, OperationHandler> OPERATION_MAP = new HashMap<>();
    private static final StorageUpdateService STORAGE_UPDATE_VALUE
            = new StorageUpdateServiceImpl(OPERATION_MAP);
    private static final GetListOfTransactions LIST_OF_TRANSACTIONS
            = new GetListOfTransactionsImpl();
    private static final DataWriter DATA_WRITER = new DataWriterImpl();
    private static final ReportCreator REPORT_CREATOR = new ReportCreatorImpl();
    private static final String PATH_TO_FILE_WITH_DATA = "src/main/resources/data.csv";
    private static final String PATH_TO_WRITE_REPORT = "src/main/resources/report.csv";

    static {
        OPERATION_MAP.put(Operation.BALANCE, new BalanceHandlerImpl());
        OPERATION_MAP.put(Operation.SUPPLY, new SupplyHandlerImpl());
        OPERATION_MAP.put(Operation.PURCHASE, new PurchaseHandlerImpl());
        OPERATION_MAP.put(Operation.RETURN, new PurchaseHandlerImpl());
    }

    public static void main(String[] args) {
        String data = DATA_READER.readData(PATH_TO_FILE_WITH_DATA);
        List<FruitTransaction> fruitTransactions = LIST_OF_TRANSACTIONS.getListOfTransactions(data);
        STORAGE_UPDATE_VALUE.updateValue(fruitTransactions);
        String report = REPORT_CREATOR.createReport();
        DATA_WRITER.writeData(PATH_TO_WRITE_REPORT, report);
    }
}

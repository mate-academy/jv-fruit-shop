package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataReader;
import core.basesyntax.service.DataWriter;
import core.basesyntax.service.GetListOfTransactions;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.impl.DataReaderImpl;
import core.basesyntax.service.impl.DataWriterImpl;
import core.basesyntax.service.impl.GetListOfTransactionsImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import java.util.List;

public class Main {
    private static final DataReader DATA_READER = new DataReaderImpl();
    private static final StorageDao STORAGE_DAO = new StorageDaoImpl();
    private static final GetListOfTransactions LIST_OF_TRANSACTIONS
            = new GetListOfTransactionsImpl();
    private static final DataWriter DATA_WRITER = new DataWriterImpl();
    private static final ReportCreator REPORT_CREATOR = new ReportCreatorImpl();
    private static final String PATH_TO_FILE_WITH_DATA = "src/main/resources/data.csv";
    private static final String PATH_TO_WRITE_REPORT = "src/main/resources/report.csv";

    public static void main(String[] args) {
        String data = DATA_READER.readData(PATH_TO_FILE_WITH_DATA);
        List<FruitTransaction> fruitTransactions = LIST_OF_TRANSACTIONS.getListOfTransactions(data);
        STORAGE_DAO.updateValue(fruitTransactions);
        String report = REPORT_CREATOR.createReport();
        DATA_WRITER.writeData(PATH_TO_WRITE_REPORT, report);
    }
}

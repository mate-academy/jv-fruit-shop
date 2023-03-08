package core.basesyntax;

import core.basesyntax.calculation.CalculationService;
import core.basesyntax.calculation.CalculationServiceImpl;
import core.basesyntax.dao.StorageTransactionsDao;
import core.basesyntax.dao.StorageTransactionsDaoImpl;
import core.basesyntax.db.StorageTransactions;
import java.io.File;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private final StorageTransactionsDao storageTransactions = new StorageTransactionsDaoImpl();
    private final CalculationService calculationService = new CalculationServiceImpl();

    @Override
    public File sendReport(File input) {
        List<String[]> listOfData = storageTransactions.convertFileIntoList(input);
        calculationService.initializationStorage(listOfData);
        calculationService.calculation(listOfData);
        String textOfReport = storageTransactions.formingReport(StorageTransactions.getStorage());
        return storageTransactions.sentReport(textOfReport);
    }
}

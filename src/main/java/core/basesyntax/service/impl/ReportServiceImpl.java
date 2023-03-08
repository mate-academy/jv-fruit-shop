package core.basesyntax.service.impl;

import static core.basesyntax.db.Storage.getStorage;

import core.basesyntax.service.ReportService;
import core.basesyntax.service.StorageTransactions;
import core.basesyntax.strategy.CalculationService;
import core.basesyntax.strategy.CalculationServiceImpl;
import java.io.File;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private final StorageTransactions storageTransactions = new StorageTransactionsImpl();
    private final CalculationService calculationService = new CalculationServiceImpl();

    @Override
    public File sendReport(File input) {
        List<String[]> listOfData = storageTransactions.convertFileIntoList(input);
        calculationService.initializationStorage(listOfData);
        calculationService.calculation(listOfData);
        String textOfReport = storageTransactions.formingReport(getStorage());
        return storageTransactions.sentReport(textOfReport);
    }
}

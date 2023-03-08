package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.CalculationService;
import core.basesyntax.service.FormingReport;
import core.basesyntax.service.ReadWriteOperations;
import core.basesyntax.service.ReportService;
import java.io.File;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private final ReadWriteOperations readWriteOperations = new ReadWriteOperationsImpl();
    private final CalculationService calculationService = new CalculationServiceImpl();
    private final FormingReport formingReport = new FormingReportImpl();

    @Override
    public File sendReport(File input) {
        List<String> listOfData = readWriteOperations.readInfoFromFile(input);
        calculationService.initializationStorage(listOfData);
        calculationService.calculation(listOfData);
        String textOfReport = formingReport.formingReport(Storage.getStorage());
        return readWriteOperations.writeReport(textOfReport);
    }
}

package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.activitieswithfruitservice.ActivitiesStrategy;
import core.basesyntax.service.activitieswithfruitservice.impl.ActivitiesStrategyImpl;
import core.basesyntax.service.createreportservice.CreateReportService;
import core.basesyntax.service.createreportservice.impl.CreateReportServiceImpl;
import core.basesyntax.service.readfromfileservice.ReadFromFileService;
import core.basesyntax.service.readfromfileservice.impl.ReadFromFileCsvServiceImpl;
import core.basesyntax.service.writetofileservice.WriteToFileService;
import core.basesyntax.service.writetofileservice.impl.WriteToCsvFileServiceImpl;
import java.util.List;

public class Main {
    private static final ReadFromFileService csvFileReader
            = new ReadFromFileCsvServiceImpl();
    private static final WriteToFileService csvFileWriter
            = new WriteToCsvFileServiceImpl();
    private static final ActivitiesStrategy activitiesStrategy = new ActivitiesStrategyImpl();
    private static final CreateReportService createReportService = new CreateReportServiceImpl();

    public static void main(String[] args) {
        String filePath
                = "src/main/java/resources/information_about_activities_in_store.csv";
        List<FruitTransaction> fruitTransactionsList
                = csvFileReader.readFromCsvFile(filePath);
        for (FruitTransaction fruitTransaction : fruitTransactionsList) {
            activitiesStrategy.performTransaction(fruitTransaction.getOperation().getCode(),
                    fruitTransaction);
        }
        String report = createReportService.getReport(Storage.fruitStorage);
        csvFileWriter.writeDataToFile(report);
    }
}

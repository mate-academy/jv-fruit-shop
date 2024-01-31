package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.activitieswithfruitservice.TransactionStrategy;
import core.basesyntax.service.activitieswithfruitservice.impl.TransactionStrategyImpl;
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
    private static final TransactionStrategy transactionStrategy = new TransactionStrategyImpl();
    private static final CreateReportService createReportService = new CreateReportServiceImpl();

    public static void main(String[] args) {
        final String FilePath
                = "src/main/java/resources/information_about_activities_in_store.csv";
        List<FruitTransaction> fruitTransactionsList
                = csvFileReader.readFromCsvFile(FilePath);
        for (FruitTransaction fruitTransaction : fruitTransactionsList) {
            transactionStrategy.getTransactionHandler(fruitTransaction)
                    .performTransaction(fruitTransaction);
        }
        String report = createReportService.getReport(Storage.fruitStorage);
        csvFileWriter.writeDataToFile(report);
    }
}

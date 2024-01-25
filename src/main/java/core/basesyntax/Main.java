package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.activitieswithfruitservice.ActivitiesStrategy;
import core.basesyntax.service.activitieswithfruitservice.impl.ActivitiesStrategyImpl;
import core.basesyntax.service.readfromfileservice.ReadFromFileService;
import core.basesyntax.service.readfromfileservice.impl.ReadFromFileCsvServiceImpl;
import core.basesyntax.service.writetofileservice.WriteToFileService;
import core.basesyntax.service.writetofileservice.impl.WriteToCsvFileServiceImpl;
import java.util.List;

public class Main {
    private static final ReadFromFileService CSV_FILE_READER_SERVICE
                = new ReadFromFileCsvServiceImpl();
    private static final WriteToFileService CVS_FILE_WRITER_SERVICE
            = new WriteToCsvFileServiceImpl();
    private static final ActivitiesStrategy ACTIVITIES_STRATEGY = new ActivitiesStrategyImpl();

    public static void main(String[] args) {
        String filePath
                = "src/main/resources/information_about_activities_in_store.csv";
        List<FruitTransaction> fruitTransactionsList
                = CSV_FILE_READER_SERVICE.readFromCsvFile(filePath);
        for (FruitTransaction fruitTransaction : fruitTransactionsList) {
            ACTIVITIES_STRATEGY.getActivitiesWithFruit(fruitTransaction.getOperation().getCode(),
                    fruitTransaction);
        }
        CVS_FILE_WRITER_SERVICE.writeDataToFile(Storage.fruitStorage);
    }
}

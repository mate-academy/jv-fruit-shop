package core.basesyntax;

import core.basesyntax.filedata.DataConvertor;
import core.basesyntax.filedata.DataConvertorImpl;
import core.basesyntax.filedata.FileReader;
import core.basesyntax.filedata.FileReaderImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.report.FileWriter;
import core.basesyntax.report.FileWriterImpl;
import core.basesyntax.report.ReportRecorder;
import core.basesyntax.report.ReportRecorderImpl;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitShopServiceImpl;
import core.basesyntax.storage.FruitStorage;
import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fromFileName = "src/main/resources/text.csv";
        String toFileName = "src/main/resources/report/report.csv";

        FileReader fileReader = new FileReaderImpl();
        DataConvertor dataConvertor = new DataConvertorImpl();
        FruitShopService fruitShopService = new FruitShopServiceImpl();
        ReportRecorder reportRecorder = new ReportRecorderImpl();
        FileWriter fileWriter = new FileWriterImpl();

        String[] fileData = fileReader.readFromFile(new File(fromFileName));
        List<FruitTransaction> fruitTransactions = dataConvertor.convertData(fileData);
        fruitShopService.processAll(fruitTransactions);
        List<String> storageData = reportRecorder.getStorageData(FruitStorage.storageMap);
        fileWriter.writeToFile(storageData, toFileName);
    }
}

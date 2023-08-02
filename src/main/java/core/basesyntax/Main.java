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
    public static final String fromFileName = "src/main/resources/text.csv";
    public static final String toFileName = "src/main/resources/report/report.csv";

    public static final FileReader fileReader = new FileReaderImpl();
    public static final DataConvertor dataConvertor = new DataConvertorImpl();
    public static final FruitShopService fruitShopService = new FruitShopServiceImpl();
    public static final ReportRecorder reportRecorder = new ReportRecorderImpl();
    public static final FileWriter fileWriter = new FileWriterImpl();

    public static void main(String[] args) {
        String[] fileData = fileReader.readFromFile(new File(fromFileName));
        List<FruitTransaction> fruitTransactions = dataConvertor.convertData(fileData);
        fruitShopService.processAll(fruitTransactions);
        List<String> storageData = reportRecorder.getStorageData(FruitStorage.storageMap);
        fileWriter.writeToFile(storageData, toFileName);
    }
}

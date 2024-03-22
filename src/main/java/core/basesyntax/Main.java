package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.filehandler.FileWriter;
import core.basesyntax.service.filehandler.ReadFromFile;
import core.basesyntax.service.filehandler.ReportGenerator;
import core.basesyntax.service.functionalityexpansion.ActivityHandlerProvider;
import core.basesyntax.service.parsefileinfo.FruitInfo;
import core.basesyntax.service.parsefileinfo.FruitParser;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/StorageInfo.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/StorageReport.csv";

    public static void main(String[] args) {
        FruitParser fruitParser = new FruitParser();
        FruitShopService fruitShopService = new FruitShopService();
        Storage data = new Storage();
        ActivityHandlerProvider activityProvider = new ActivityHandlerProvider(data);
        ReadFromFile fileInfo = new ReadFromFile();
        FileWriter fileWriter = new FileWriter();
        ReportGenerator reportGenerator = new ReportGenerator();

        activityProvider.putStrategyByKey();
        List<String> lines = fileInfo.readFromFile(INPUT_FILE_PATH);

        List<FruitInfo> fruits = lines.stream()
                .map(fruitParser::parseActivity)
                .collect(Collectors.toList());

        fruitShopService.execute(fruits, activityProvider);
        String report = reportGenerator.generate(data);
        fileWriter.write(REPORT_FILE_PATH, report);
    }
}

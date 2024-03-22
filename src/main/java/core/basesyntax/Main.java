package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.filehandler.FileReader;
import core.basesyntax.service.filehandler.FileWriter;
import core.basesyntax.service.filehandler.ReportGenerator;
import core.basesyntax.service.functionalityexpansion.ActivityHandlerProvider;
import core.basesyntax.service.parsefileinfo.FruitTransactionInfo;
import core.basesyntax.service.parsefileinfo.TransactionParser;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/StorageInfo.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/StorageReport.csv";

    public static void main(String[] args) {
        TransactionParser transactionParser = new TransactionParser();
        Storage storage = new Storage();
        ActivityHandlerProvider activityProvider = new ActivityHandlerProvider(storage);
        FruitShopService fruitShopService = new FruitShopService(activityProvider);
        FileReader fileInfo = new FileReader();
        FileWriter fileWriter = new FileWriter();
        ReportGenerator reportGenerator = new ReportGenerator();

        List<String> lines = fileInfo.readFromFile(INPUT_FILE_PATH);

        List<FruitTransactionInfo> fruits = lines.stream()
                .map(transactionParser::parse)
                .collect(Collectors.toList());

        fruitShopService.execute(fruits);
        String report = reportGenerator.generate(storage);
        fileWriter.write(REPORT_FILE_PATH, report);
    }
}

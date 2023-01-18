package core.basesyntax;

import core.basesyntax.processing.FruitReport;
import core.basesyntax.processing.FruitTransaction;
import core.basesyntax.processing.FruitTransactionImpl;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FileServiceImpl;
import java.util.List;
import java.util.Map;

public class FruitShop {
    private String fromFilePath;
    private String toFilePath;
    private final FileService fileService = new FileServiceImpl();
    private final FruitTransaction fruitTransaction = new FruitTransactionImpl();
    private final FruitReport fruitReport = new FruitReport();

    public void process() {
        List<String> activities = fileService.readFromFile(fromFilePath);
        Map<String, Integer> storage = fruitTransaction.storage(activities);
        String report = fruitReport.getFruitReport(storage);
        fileService.writeInFile(report, toFilePath);
    }
}

package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.processing.FruitReport;
import core.basesyntax.processing.FruitTransaction;
import core.basesyntax.processing.FruitTransactionImpl;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FileServiceImpl;
import java.util.List;

public class FruitShop {

    public void processing() {
        FileService fileService = new FileServiceImpl();
        String fromFilePath = "src/main/resources/input.csv";
        List<String> activities = fileService.readFromFile(fromFilePath);

        FruitTransaction fruitTransaction = new FruitTransactionImpl();
        fruitTransaction.processing(activities);

        FruitReport fruitReport = new FruitReport();
        String report = fruitReport.getFruitReport(Storage.getFruits());

        String toFilePath = "src/main/resources/report.csv";
        fileService.writeInFile(report, toFilePath);
    }

    public static void main(String[] args) {
        FruitShop fruitShop = new FruitShop();
        fruitShop.processing();
    }
}

package core.basesyntax;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.services.FruitsService;
import core.basesyntax.services.FruitsServiceImpl;
import core.basesyntax.transactions.FruitsTransaction;
import core.basesyntax.util.CsvUtils;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();
        FruitsDao fruitsDao = new FruitsDaoImpl(storage);
        FruitsService fruitsService = new FruitsServiceImpl(fruitsDao);
        Path inputFilePath = Path.of(
                "src","main","java","core","basesyntax","resources", "inputFile.csv");
        Path outputFilePath = Path.of(
                "src","main","java","core","basesyntax","resources", "output.csv");
        List<FruitsTransaction> transactions = CsvUtils.readTransactions(inputFilePath);
        fruitsService.processTransactions(transactions);
        String report = fruitsService.createReport();
        CsvUtils.writeReport(outputFilePath, report);
    }
}

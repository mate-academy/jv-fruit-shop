package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.Parser;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.ParserImpl;
import java.util.List;

public class Main {
    private static final String PATH = "src/main/java/core/basesyntax/db/data.csv";
    private static final String REPORT = "src/main/java/core/basesyntax/db/report.csv";

    public static void main(String[] args) {
        FileReader reader = new FileReaderImpl();
        FileWriter writer = new FileWriterImpl();
        Parser parser = new ParserImpl();
        FruitShopService transactions = new FruitShopServiceImpl();
        List<String> dataFromFile = reader.readData(PATH);
        List<FruitTransaction> parsedTransactions = parser.parseTransactions(dataFromFile);
        transactions.fruitTransaction(parsedTransactions);
        writer.writeToFile(Storage.storage, REPORT);
    }
}

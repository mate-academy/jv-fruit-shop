import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReader;
import core.basesyntax.service.CsvFileWriter;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.CsvFileReaderImpl;
import core.basesyntax.service.impl.CsvFileWriterImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import java.util.List;

public class Main {
    private static final String FROM_THIS_FILE = "input.csv";
    private static final String TO_THIS_FILE = "report.csv";

    public static void main(String[] args) {
        CsvFileReader reader = new CsvFileReaderImpl();
        List<FruitTransaction> transactions = reader.readFromFile(FROM_THIS_FILE);

        FruitStorage fruitStorage = new FruitStorage();
        FruitService fruitService = new FruitServiceImpl(fruitStorage);
        fruitService.processTransactions(transactions);

        for (FruitTransaction transaction : transactions) {
            fruitStorage.updateFruitQuantity(transaction.getFruit(), transaction.getQuantity());
        }

        List<String> reportData = fruitService.generateReport();

        CsvFileWriter writer = new CsvFileWriterImpl();
        writer.writeToFile(TO_THIS_FILE, reportData);
    }
}

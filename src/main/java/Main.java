
import core.basesyntax.db.FruitStorage;
import core.basesyntax.service.CsvFileWriter;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitTransactionReader;
import core.basesyntax.service.impl.CsvFileWriterImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.FruitTransactionReaderImpl;


public class Main {
    private static final String FROM_THIS_FILE = "input.csv";

    public static void main(String[] args) {
        FruitStorage fruitStorage = new FruitStorage();
        FruitTransactionReader transactionReader = new FruitTransactionReaderImpl();
        CsvFileWriter csvFileWriter = new CsvFileWriterImpl();

        FruitService fruitService = new FruitServiceImpl(
                fruitStorage, transactionReader, csvFileWriter);

        fruitService.processTransactions(transactionReader.readFromFile(FROM_THIS_FILE));
        fruitService.generateReport();
    }
}

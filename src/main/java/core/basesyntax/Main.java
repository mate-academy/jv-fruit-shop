package core.basesyntax;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.*;

import java.util.List;

public class Main {
    private static final String INPUT_FILE = "input.csv";
    private static final String OUTPUT_FILE = "result.csv";

    public static void main(String[] args) {
        ReaderServiceImpl reader = new ReaderServiceImpl();
        List<String> dataAll = reader.readFromFile(INPUT_FILE);
        FruitTransactionParserImpl fruitTransactionParser = new FruitTransactionParserImpl();
        List<FruitTransaction> transactions = fruitTransactionParser
                .getFruitTransactionsList(dataAll);

        FruitStorage fruitStorage = new FruitStorage();
        FruitService fruitServiceImpl = new FruitServiceImpl(fruitStorage);
        fruitServiceImpl.processTransactions(transactions);

        ReportServiceImpl reportServiceImpl = new ReportServiceImpl();
        List<String> reportData = reportServiceImpl.generateReport();

        WriterServiceImpl writer = new WriterServiceImpl();
        writer.writeToFile(OUTPUT_FILE, reportData);
    }
}

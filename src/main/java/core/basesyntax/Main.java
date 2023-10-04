package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.FruitTransactionParserImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
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

        FruitService fruitServiceImpl = new FruitServiceImpl();
        fruitServiceImpl.processTransactions(transactions);

        ReportServiceImpl reportServiceImpl = new ReportServiceImpl();
        String reportData = reportServiceImpl.generateReport();

        WriterServiceImpl writer = new WriterServiceImpl();
        writer.writeToFile(OUTPUT_FILE, reportData);
    }
}

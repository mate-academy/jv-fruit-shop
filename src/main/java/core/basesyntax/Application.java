package core.basesyntax;

import core.basesyntax.service.Parser;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransferToDb;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ReaderCsvImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransferToDbImpl;
import core.basesyntax.service.impl.WriterToCsvImpl;
import core.basesyntax.strategy.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Reader reader = new ReaderCsvImpl("src/main/resources/input/testFile.csv");
        Parser parser = new ParserImpl();
        OperationStrategy strategy = new OperationStrategyImpl();
        TransferToDb transferToDb = new TransferToDbImpl(strategy);
        ReportService reportService = new ReportServiceImpl();
        WriterToCsvImpl writerToCsv = new WriterToCsvImpl("src/main/resources/output");

        List<FruitTransaction> fruitTransactions = parser.parse(reader.readFile());
        transferToDb.transfer(fruitTransactions);
        writerToCsv.writeToFile(reportService.createReport());
    }
}

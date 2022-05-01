package core.basesyntax;

import core.basesyntax.config.Configuration;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionHandler;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CsvParserService;
import core.basesyntax.service.impl.FruitTransactionHandler;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.StorageDailyReport;
import core.basesyntax.service.impl.WriterServiceImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReaderService reader = new ReaderServiceImpl();
        ParserService parser = new CsvParserService();
        TransactionHandler fruitTransactionHandler = new FruitTransactionHandler();
        ReportService reportService = new StorageDailyReport();
        WriterService writer = new WriterServiceImpl();

        List<String> lines = reader.read(Configuration.READ_PATH);
        List<FruitTransaction> transactionList = parser.parse(lines);
        fruitTransactionHandler.execute(transactionList);
        writer.write(Configuration.WRITE_PATH, reportService.makeReport());
    }
}

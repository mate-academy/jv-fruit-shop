package core.basesyntax;

import core.basesyntax.db.InMemoryStorage;
import core.basesyntax.model.ItemTransaction;
import core.basesyntax.service.Converter;
import core.basesyntax.service.DataWriter;
import core.basesyntax.service.TransactionHandler;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.ConverterImpl;
import core.basesyntax.service.impl.DataWriterImpl;
import core.basesyntax.service.impl.TransactionHandlerImpl;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import java.util.List;

public class Main {
    private final static String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private final static String OUTPUT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Reader csvReader = new ReaderImpl();
        List<String> strings = csvReader.read(INPUT_FILE_PATH);
        Converter converter = new ConverterImpl();
        List<ItemTransaction> itemTransactions = converter.convert(strings);

        TransactionHandler transactionHandler = new TransactionHandlerImpl();
        transactionHandler.handle(itemTransactions);

        ReportService reportService = new ReportServiceImpl();
        List<String> report = reportService.report();

        DataWriter dataWriter = new DataWriterImpl();
        dataWriter.write(report, OUTPUT_FILE_PATH);
    }
}

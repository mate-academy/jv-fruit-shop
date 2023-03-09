package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FormingReport;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.TransactionParserService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CalculationImpl;
import core.basesyntax.service.impl.FormingReportImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.TransactionParserServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import java.io.File;
import java.util.List;

public class Main {
    private static final String FILE_NAME = "input.csv";
    private static final ReaderService READER_SERVICE = new ReaderServiceImpl();
    private static final FormingReport FORMING_REPORT = new FormingReportImpl();
    private static final TransactionParserService PARSER = new TransactionParserServiceImpl();
    private static final WriterService WRITER_SERVICE = new WriterServiceImpl();
    private static final CalculationImpl CALCULATION = new CalculationImpl();

    public static void main(String[] args) {
        File dataFile = new File(FILE_NAME);
        List<String> listOfData = READER_SERVICE.readInfoFromFile(dataFile);
        List<FruitTransaction> parsedData = PARSER.parseData(listOfData);
        CALCULATION.calculation(parsedData);
        String textOfReport = FORMING_REPORT.formingReport(Storage.STORAGE);
        WRITER_SERVICE.writeReport(textOfReport);
    }
}

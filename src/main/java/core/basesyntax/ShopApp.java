package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitTransactionParser;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitTransactionParserImpl;
import core.basesyntax.service.impl.FruitTransactionServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import java.util.List;

public class ShopApp {
    private static final String INPUT_FILE_NAME = "src/main/resources/inputFile.csv";
    private static final String REPORT_NAME = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FileReaderService read = new FileReaderServiceImpl();
        List<String> listWithFile = read.readFromFile(INPUT_FILE_NAME);

        FruitTransactionParser parseData = new FruitTransactionParserImpl();
        List<FruitTransaction> fruitTransactions = parseData.parse(listWithFile);

        FruitDao fruitDao = new FruitDaoImpl();

        FruitTransactionService fruitTransactionService = new FruitTransactionServiceImpl(fruitDao);
        fruitTransactionService.process(fruitTransactions);

        ReportService createReport = new ReportServiceImpl(fruitDao);
        List<String> resultReport = createReport.generatedReport();

        FileWriterService write = new FileWriterServiceImpl();
        write.writeToFile(REPORT_NAME, resultReport);
    }
}

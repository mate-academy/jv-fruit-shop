package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.fileservice.CsvFileReaderService;
import core.basesyntax.fileservice.CsvFileWriterService;
import core.basesyntax.fileservice.impl.CsvFileReaderServiceImpl;
import core.basesyntax.fileservice.impl.CsvFileWriterServiceImpl;
import core.basesyntax.sevrice.InfoParser;
import core.basesyntax.sevrice.OperationExecutor;
import core.basesyntax.sevrice.ReportMaker;
import core.basesyntax.sevrice.impl.InfoParserImpl;
import core.basesyntax.sevrice.impl.OperationExecutorImpl;
import core.basesyntax.sevrice.impl.ReportMakerImpl;
import java.nio.file.Path;
import java.util.List;

public class Main {
    private static final Path READ_FROM_FILE = Path.of("src/main/resources/dailyActivities.csv");
    private static final Path WRITE_TO_FILE = Path.of("src/main/resources/report.csv");

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        OperationExecutor operationExecutor = new OperationExecutorImpl();
        InfoParser infoParser = new InfoParserImpl();
        CsvFileReaderService csvFileReaderService = new CsvFileReaderServiceImpl();
        CsvFileWriterService csvFileWriterService = new CsvFileWriterServiceImpl();
        ReportMaker reportMaker = new ReportMakerImpl(fruitDao);

        List<String> textFromSource = csvFileReaderService.readFromFile(READ_FROM_FILE);
        infoParser.parseToFruitTransactionList(textFromSource).forEach(operationExecutor::execute);
        csvFileWriterService.writeToFile(reportMaker.createReport(), WRITE_TO_FILE);
        csvFileWriterService.writeToFile("report", WRITE_TO_FILE);

    }
}

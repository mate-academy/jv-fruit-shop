package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CsvReaderService;
import core.basesyntax.service.impl.CsvWriterService;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.operation.OperationStrategy;
import core.basesyntax.service.operation.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class Main {
    private static final ReaderService READER_SERVICE = new CsvReaderService();
    private static final WriterService WRITER_SERVICE = new CsvWriterService();
    private static final Parser PARSER_SERVICE = new ParserImpl();
    private static final OperationStrategy OPERATION_STRATEGY = new OperationStrategyImpl();
    private static final FruitDao FRUIT_DAO = new FruitDaoImpl(OPERATION_STRATEGY);
    private static final ReportService REPORT_SERVICE = new ReportServiceImpl();
    private static final String INPUT_FILE_PATH = "src/main/resources/CsvInputData.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/CsvReport.csv";

    public static void main(String[] args) {
        List<String> fileData = READER_SERVICE.read(INPUT_FILE_PATH);
        List<FruitTransaction> transactions = PARSER_SERVICE.parseDataFromFile(fileData);
        FRUIT_DAO.addAll(transactions);
        Map<String, Integer> dataFromDatabase = FRUIT_DAO.getAll();
        String report = REPORT_SERVICE.createReport(dataFromDatabase);
        WRITER_SERVICE.write(report, OUTPUT_FILE_PATH);
    }
}

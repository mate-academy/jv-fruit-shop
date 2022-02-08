package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.Parser;
import core.basesyntax.service.Reader;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.Validator;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.DataParser;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.ReportValidator;
import core.basesyntax.service.impl.StorageServiceImpl;
import core.basesyntax.service.impl.WriterImpl;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class Main {
    private static final String INPUT_DATA_FILE_PATH
            = "src/main/resources/daily_report.csv";
    private static final String REPORT_FILE_PATH
            = "src/main/resources/report.csv";

    public static void main(String[] args) {
        StorageDao<Fruit> storageDao = new StorageDaoImpl();
        StorageService storageService = new StorageServiceImpl(storageDao,
                new OperationStrategy(storageDao));
        Parser dataParser = new DataParser();
        Reader reader = new ReaderImpl();
        List<String> inputData = reader.read(INPUT_DATA_FILE_PATH);
        Validator reportValidator = new ReportValidator();
        reportValidator.test(inputData);
        storageService.updateStorage(dataParser.formatInputData(inputData));
        String data = dataParser.formatReport(storageService.getStorageStatistic());
        Writer writer = new WriterImpl();
        writer.write(REPORT_FILE_PATH, data);
    }
}

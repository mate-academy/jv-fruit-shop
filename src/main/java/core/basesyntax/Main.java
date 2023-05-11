package core.basesyntax;

import core.basesyntax.dao.ProductDaoService;
import core.basesyntax.dao.ProductDaoServiceImpl;
import core.basesyntax.service.ConvertService;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.DataHandlingService;
import core.basesyntax.service.impl.ConvertServiceImpl;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvFileWriterServiceImpl;
import core.basesyntax.service.impl.DataHandlingServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class Main {
    private static final String VALID_SOURCE_PATH = "src//main//resources//Information.csv";
    private static final String INVALID_SOURCE_PATH = "src//main//resources//InvalidData.csv";
    private static final String NEGATIVE_OPERATION_SOURCE_PATH =
            "src//main//resources//ExceptionData.csv";
    private static final String WRITE_TO_FILE_PATH = "src//main//resources//Report.csv";

    public static void main(String[] args) {
        CsvFileReaderService fileReaderService = new CsvFileReaderServiceImpl();
        List<String> dataFromFile = fileReaderService.readDataFromSource(VALID_SOURCE_PATH);
        ConvertService convertService = new ConvertServiceImpl();
        ProductDaoService productDaoService = new ProductDaoServiceImpl();
        OperationStrategy operationStrategy =
                new OperationStrategy(productDaoService);
        DataHandlingService dataHandlingService =
                new DataHandlingServiceImpl(convertService, operationStrategy);
        dataHandlingService.processing(dataFromFile);
        CsvFileWriterService csvFileWriterService = new CsvFileWriterServiceImpl(productDaoService);
        csvFileWriterService.writeToFile(WRITE_TO_FILE_PATH);
    }
}

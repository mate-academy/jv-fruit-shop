package core.basesyntax;

import core.basesyntax.db.DaoService;
import core.basesyntax.db.impl.DaoServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Calculator;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.DataProcessor;
import core.basesyntax.service.impl.CalculatorImpl;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvFileWriterServiceImpl;
import core.basesyntax.service.impl.DataProcessorImpl;
import java.util.List;

public class Application {
    private static final String READ_FROM_FILE =
            "src\\main\\java\\core\\basesyntax\\resourses\\ValidReadFromFile.csv";
    private static final String NEGATIVE_QUANTITY_READ_FROM_FILE =
            "src\\main\\java\\core\\basesyntax\\resourses\\NegativeQuantityReadFromFile.csv";
    private static final String WRITE_TO_FILE =
            "src\\main\\java\\core\\basesyntax\\resourses\\WriteToFile.csv";

    public static void main(String[] args) {
        CsvFileReaderService fileReader = new CsvFileReaderServiceImpl();
        DataProcessor dataProcessor = new DataProcessorImpl();
        Calculator calculator = new CalculatorImpl();
        DaoService daoService = new DaoServiceImpl();
        CsvFileWriterService csvFileWriterService = new CsvFileWriterServiceImpl();
        List<FruitTransaction> fruitTransactions =
                dataProcessor.getTransactions(fileReader.readFormFile(READ_FROM_FILE));
        daoService.addDataToStorage(calculator.calculate(fruitTransactions));
        csvFileWriterService.writeToFile(WRITE_TO_FILE);
    }
}

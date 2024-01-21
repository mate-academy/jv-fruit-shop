package core.basesyntax;

import impl.FileReaderImpl;
import impl.ParseDataServiceImpl;
import impl.ReportServiceImpl;
import impl.WriterServiceImpl;
import java.util.List;
import model.Fruit;
import service.Transaction;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    private static final String INPUT_FILE = "src/main/java/Files/InputData.CSV";
    private static final String OUTPUT_FILE = "src/main/java/Files/ReportData.CSV";
    private static final FileReaderImpl fileReader = new FileReaderImpl();
    private static final ParseDataServiceImpl parse = new ParseDataServiceImpl();
    private static final ReportServiceImpl reportService = new ReportServiceImpl();
    private static final WriterServiceImpl writerService = new WriterServiceImpl();
    private static final Transaction transaction = new Transaction();

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        List<String> dataFromFile = fileReader.dataFromFile(INPUT_FILE);
        List<Fruit> fruitsList = parse.parseData(dataFromFile);
        transaction.transactionFruits(fruitsList);
        String resultOfWork = reportService.createReport();
        writerService.writeDataToFile(resultOfWork, OUTPUT_FILE);
    }
}

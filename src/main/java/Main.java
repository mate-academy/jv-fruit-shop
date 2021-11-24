import core.basesyntax.model.OperationFruitDto;
import core.basesyntax.operationstrategy.OperationService;
import core.basesyntax.operationstrategy.OperationStrategy;
import core.basesyntax.service.DataValidator;
import core.basesyntax.service.ParserValidData;
import core.basesyntax.service.ReaderFromFile;
import core.basesyntax.service.WriterToFile;
import core.basesyntax.service.impl.DataValidatorImpl;
import core.basesyntax.service.impl.ParserValidDataImpl;
import core.basesyntax.service.impl.ReaderFromFileCsvImpl;
import core.basesyntax.service.impl.ReportServiceImp;
import core.basesyntax.service.impl.WriterToFileCsvImpl;
import java.io.File;
import java.util.List;

public class Main {
    private static final String DEFAULT_PATH = "src/main/resources/";
    private static final File DEFAULT_READ_FILE = new File(DEFAULT_PATH + "storeGood.csv");
    private static final File DEFAULT_WRITE_FILE = new File(DEFAULT_PATH + "report.csv");

    public static void main(String[] args) {
        testProject(DEFAULT_READ_FILE);
        System.out.println("The first test passed!");
    }

    public static void testProject(File file) {
        ReaderFromFile myReaderCsv = new ReaderFromFileCsvImpl();
        List<String> strings = myReaderCsv.read(file);

        DataValidator dataValidator = new DataValidatorImpl();
        for (String string : strings) {
            dataValidator.validate(string);
        }

        ParserValidData parserValidData = new ParserValidDataImpl();
        OperationService operationService = new OperationStrategy();
        for (String string : strings) {
            OperationFruitDto operationFruitDto = parserValidData.parse(string);
            operationService.apply(operationFruitDto);
        }
        List<String> report = new ReportServiceImp().createReport();

        WriterToFile writerToFile = new WriterToFileCsvImpl();
        writerToFile.write(report, DEFAULT_WRITE_FILE);
    }
}

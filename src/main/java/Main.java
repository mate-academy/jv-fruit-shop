import core.basesyntax.model.OperationFruitDto;
import core.basesyntax.operationstrategy.OperationService;
import core.basesyntax.operationstrategy.OperationStrategy;
import core.basesyntax.service.CheckDataValidation;
import core.basesyntax.service.ParseValidData;
import core.basesyntax.service.ReadDataFromFile;
import core.basesyntax.service.WriteDataToFile;
import core.basesyntax.service.impl.CheckDataValidationImpl;
import core.basesyntax.service.impl.CreateReportImp;
import core.basesyntax.service.impl.ParseValidDataImpl;
import core.basesyntax.service.impl.ReadDataFromFileCsvImpl;
import core.basesyntax.service.impl.WriteDataToFileCsvImpl;
import java.io.File;
import java.util.List;

public class Main {
    private static final String DEFAULT_PATH = "src/main/resources/";
    private static final File DEFAULT_GOOD_FILE = new File(DEFAULT_PATH + "storeGood.csv");
    private static final File DEFAULT_BAD_FILE = new File(DEFAULT_PATH + "storeBad.csv");
    private static final File DEFAULT_WRITE_FILE = new File(DEFAULT_PATH + "report.csv");

    public static void main(String[] args) {
        testProject(DEFAULT_GOOD_FILE);
        System.out.println("The first test passed!");
        testProject(DEFAULT_BAD_FILE);
        System.out.println("The second test must not pass!");
    }

    public static void testProject(File file) {
        ReadDataFromFile listFromFile = new ReadDataFromFileCsvImpl();
        List<String> strings = listFromFile.readFromFile(file);

        CheckDataValidation checkDataValidation = new CheckDataValidationImpl();
        for (String string : strings) {
            checkDataValidation.checkStringValidation(string);
        }

        ParseValidData parseValidData = new ParseValidDataImpl();
        OperationService operationService = new OperationStrategy();
        for (String string : strings) {
            OperationFruitDto operationFruitDto = parseValidData.parseValidDataImpl(string);
            operationService.apply(operationFruitDto);
        }
        List<String> report = new CreateReportImp().createSupplyReport();
        System.out.println(report);

        WriteDataToFile writeDataToFile = new WriteDataToFileCsvImpl();
        writeDataToFile.writeListToCsvFile(report, DEFAULT_WRITE_FILE);
    }
}

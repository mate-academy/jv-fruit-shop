package core.basesyntax;

import core.basesyntax.impl.DataConverterToObject;
import core.basesyntax.impl.OperationProcess;
import core.basesyntax.impl.ReadFileFromCsv;
import core.basesyntax.impl.ReportCreator;
import core.basesyntax.impl.WriteToFileDataToCsv;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.DataProcesser;
import core.basesyntax.service.ReadFileService;
import core.basesyntax.service.WriteDataToFileService;
import java.util.List;

public class Application {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        ReadFileService readFileService = new ReadFileFromCsv();
        List<String> inputData = readFileService.readFromFile(INPUT_FILE_PATH);
        DataConverter dataConverter = new DataConverterToObject();
        List<FruitTransaction> transactions = dataConverter.convert(inputData);
        DataProcesser operationProcess = new OperationProcess();
        operationProcess.processData(transactions);
        ReportCreator reportCreator = new ReportCreator();
        WriteDataToFileService writeDataToFileService = new WriteToFileDataToCsv();
        writeDataToFileService.writeToFile(reportCreator.prepare(), OUTPUT_FILE_PATH);
    }
}

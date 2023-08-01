package core.basesyntax;

import core.basesyntax.impl.DataConverterToObject;
import core.basesyntax.impl.OperationProcess;
import core.basesyntax.impl.PrepareData;
import core.basesyntax.impl.ReadFromCsv;
import core.basesyntax.impl.WriteToCsv;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.DataProcesser;
import core.basesyntax.service.ReadService;
import core.basesyntax.service.WriteService;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        ReadService readService = new ReadFromCsv();
        List<String> inputData = readService.readFromFile("src/main/resources/input.csv");
        DataConverter dataConverter = new DataConverterToObject();
        List<FruitTransaction> transactions = dataConverter.convert(inputData);
        DataProcesser operationProcess = new OperationProcess();
        operationProcess.processData(transactions);
        PrepareData prepareData = new PrepareData();
        WriteService writeService = new WriteToCsv();
        writeService.writeToFile(prepareData.prepare(), "src/main/resources/output.csv");
    }
}

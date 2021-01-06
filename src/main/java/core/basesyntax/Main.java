package core.basesyntax;

import core.basesyntax.service.impl.*;
import core.basesyntax.service.interfaces.StrategyCreator;
import core.basesyntax.service.interfaces.DataValidator;
import core.basesyntax.service.interfaces.ReadFromFile;
import core.basesyntax.service.interfaces.WriteToFile;
import core.basesyntax.service.operations.Operation;
import java.util.List;
import java.util.Map;

public class Main {
    public static String dataPath = "src/test/resources/data";
    public static String resultPath = "src/test/resources/result";

    public static void main(String[] args) {
        Storage.storage.put("banana", 0);
        Storage.storage.put("apple", 0);

        ReadFromFile fileReader = new ReadFromFileImpl();
        StrategyCreator strategyCreator = new StrategyCreatorImpl();
        DataValidator validator = new DataValidatorImpl();
        ReportMaker reportMaker = new ReportMaker();
        WriteToFile fileWriter = new WriteToFileImpl();

        List<String> dataFromFile = fileReader.readFromFile(dataPath);
        Map<String, Operation> strategy = strategyCreator.createStrategy();

        for (String line : dataFromFile) {
            String[] record = line.split(",");
            validator.isNumberValid(record);
            validator.isOperationValid(strategy, record);
            reportMaker.doOperation(record, strategy);
        }

        String output = reportMaker.combineOutput();
        fileWriter.write(resultPath, output);
    }
}

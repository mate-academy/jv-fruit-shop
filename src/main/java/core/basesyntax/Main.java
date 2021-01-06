package core.basesyntax;

import core.basesyntax.service.impl.DataValidatorImpl;
import core.basesyntax.service.impl.ReadFromFileImpl;
import core.basesyntax.service.impl.ReportMaker;
import core.basesyntax.service.impl.StrategyCreatorImpl;
import core.basesyntax.service.impl.WriteToFileImpl;
import core.basesyntax.service.interfaces.DataValidator;
import core.basesyntax.service.interfaces.ReadFromFile;
import core.basesyntax.service.interfaces.StrategyCreator;
import core.basesyntax.service.interfaces.WriteToFile;
import core.basesyntax.service.operations.Operation;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String dataPath = "src/test/resources/data";
    public static final String resultPath = "src/test/resources/result";

    public static void main(String[] args) {
        Storage.storage.put("banana", 0);
        Storage.storage.put("apple", 0);

        ReadFromFile fileReader = new ReadFromFileImpl();
        StrategyCreator strategyCreator = new StrategyCreatorImpl();
        Map<String, Operation> strategy = strategyCreator.createStrategy();
        DataValidator validator = new DataValidatorImpl(strategy);
        ReportMaker reportMaker = new ReportMaker(strategy);
        WriteToFile fileWriter = new WriteToFileImpl();

        List<String> dataFromFile = fileReader.readFromFile(dataPath);

        for (String line : dataFromFile) {
            String[] record = line.split(",");
            validator.isNumberValid(record);
            validator.isOperationValid(record);
            reportMaker.saveDataToStorage(record);
        }

        String output = reportMaker.getDataFromStorage();
        fileWriter.write(resultPath, output);
    }
}

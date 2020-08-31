package core.basesyntax;

import core.basesyntax.model.FruitDto;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitOperation;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.CsvFileReader;
import core.basesyntax.service.impl.CsvFileWriter;
import core.basesyntax.service.impl.FruitAddition;
import core.basesyntax.service.impl.FruitReduction;
import core.basesyntax.service.impl.FruitServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        Map<Operation, FruitOperation> operationType = new HashMap<>();
        operationType.put(Operation.BALANCE, new FruitAddition());
        operationType.put(Operation.SUPPLY, new FruitAddition());
        operationType.put(Operation.RETURN, new FruitAddition());
        operationType.put(Operation.BUY, new FruitReduction());

        FileReader fileReader = new CsvFileReader();
        FruitService fruitService = new FruitServiceImpl(operationType);
        FileWriter fileWriter = new CsvFileWriter();

        List<FruitDto> fruitDtos = fileReader.readData("src/main/resources/test-fruit.csv");
        fruitService.makeOperationsOnFruitsDto(fruitDtos);
        Map<String, Long> fruitReport = fruitService.gerFruitReport();
        fileWriter.createReportFile(fruitReport, "src/main/resources/report-fruit.csv");
    }
}

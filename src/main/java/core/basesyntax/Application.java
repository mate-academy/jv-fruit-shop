package core.basesyntax;

import core.basesyntax.model.FruitDto;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.CsvFileReader;
import core.basesyntax.service.impl.CsvFileWriter;
import core.basesyntax.service.impl.FruitServiceImpl;

import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        FileReader fileReader = new CsvFileReader();
        FruitService fruitService = new FruitServiceImpl();
        FileWriter fileWriter = new CsvFileWriter();

        List<FruitDto> fruitDtos = fileReader.readData("src/main/resources/test-fruit.csv");
        Map<String, Integer> availableFruits = fruitService.getAvailableFruits(fruitDtos);
        fileWriter.createReportFile(availableFruits, "src/main/resources/report-fruit.csv");
    }
}

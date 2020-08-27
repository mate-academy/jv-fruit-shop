package core.basesyntax.service;

import core.basesyntax.dao.ReadFromFile;
import core.basesyntax.dao.WriteToFile;
import core.basesyntax.products.FruitDto;
import java.util.List;

public class Application {
    public void startApp(String fileInput) {
        List<String[]> stringsFromFile = new ReadFromFile().readFromFile(fileInput);
        List<FruitDto> fruitDtoList = new FruitDtoService().convertToFruitDto(stringsFromFile);
        Handle handle = new Handle();
        if (handle.operationWithProduct(fruitDtoList)) {
            System.out.println("Adding to list successfully");
        } else {
            System.out.println("Error with adding");
        }
    }

    public void writingToFile(String fileOutput) {
        WriteToFile writeToFile = new WriteToFile();
        if (writeToFile.writeToFile(fileOutput)) {
            System.out.println("Writing to file complit");
        } else {
            System.out.println("Error with writing to file");
        }
    }
}

package core.basesyntax.service;

import core.basesyntax.dao.ShopFileReader;
import core.basesyntax.dao.ShopFileWriter;
import core.basesyntax.products.FruitDto;
import java.util.List;

public class Application {
    public void startApp(String fileInput) {
        List<String[]> stringsFromFile = new ShopFileReader().readFromFile(fileInput);
        List<FruitDto> fruitDtoList = new FruitDtoMapper().convertToFruitDto(stringsFromFile);
        OperationHandler operationHandler = new OperationHandler();
        if (operationHandler.handlingProduct(fruitDtoList)) {
            System.out.println("Adding to list successfully");
        } else {
            System.out.println("Error with adding");
        }
    }

    public void writingToFile(String fileOutput) {
        ShopFileWriter fileWriter = new ShopFileWriter();
        if (fileWriter.writeToFile(fileOutput)) {
            System.out.println("Writing to file complete");
        } else {
            System.out.println("Error with writing to file");
        }
    }
}

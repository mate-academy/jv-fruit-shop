package core.basesyntax;

import core.basesyntax.servise.FileReadService;
import core.basesyntax.servise.FileWriteService;
import core.basesyntax.servise.FruitService;
import core.basesyntax.servise.ReadFile;
import core.basesyntax.servise.WriteFile;
import java.util.List;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) {
        FileReadService readService = new ReadFile();
        List<ProductsDto> lists = readService.readFromFile("src/test/resources/FruitTestOk.csv");
        FruitService fruitService = new FruitService();
        for (ProductsDto productsDto: lists) {
            fruitService.convert(productsDto);
        }
        FileWriteService writeService = new WriteFile();
        writeService.writeToFile(Storege.fruitStorage);
    }
}

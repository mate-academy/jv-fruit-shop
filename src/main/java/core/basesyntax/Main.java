package core.basesyntax;

import core.basesyntax.servise.*;

import java.util.List;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) {
        FileReadService readService = new ReadFile();
        List<ProductsDto> lists = readService.readFromFile("src/resources/FruitTestOk.csv");
        FruitService fruitService = new FruitService();
        for (ProductsDto productsDto: lists) {
            fruitService.convert(productsDto);
        }
        FileWriteService writeService = new WrireFile();
        writeService.writeToFile(Storege.fruitStorage);
    }
}

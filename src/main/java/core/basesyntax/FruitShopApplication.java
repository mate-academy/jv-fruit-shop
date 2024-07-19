package core.basesyntax;

import core.basesyntax.service.DataConverterImpl;
import core.basesyntax.service.DataConverterService;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FileServiceImpl;

import java.util.List;

/**
 * Feel free to remove this class and create your own.
 */
public class FruitShopApplication {
    public static void main(String[] args) {
        FileService fileService = new FileServiceImpl();
        List<String> readLines = fileService.read("fruits.csv");
        DataConverterService dataConverterService = new DataConverterImpl();
        dataConverterService.convertToFruit(readLines);
    }
}

package core.basesyntax;

import core.basesyntax.service.ReaderService;
import core.basesyntax.service.impl.ReaderServiceImpl;

import java.io.File;
import java.util.List;

/**
 * Feel free to remove this class and create your own.
 */
public class FruitShop {
    public static void main(String[] args) {
        File file = new File("src/main/resources/file.txt");
        ReaderService readerService = new ReaderServiceImpl();
        List<String> list =readerService.readFromFile(file);

    }
}

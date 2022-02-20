package core.basesyntax.FruitShopService;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Reader {

    public static List<String> readInputData(String filePath) {
        try {
            return Files.lines(Path.of(filePath)).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("can't read data from file", e);
        }

    }
}

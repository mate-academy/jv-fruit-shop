package core.basesyntax.io.ioimpl;

import core.basesyntax.io.MyReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyFileReader implements MyReader {
    @Override
    public List<String> read(String path) {
        List<String> result;
        try {
            Stream<String> lines = Files.lines(Paths.get(path));
            result = lines.collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + path, e);
        }
        return result;
    }
}

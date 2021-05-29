package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Service implements ValidateDao {
    @Override
    public List<String> validateData(String fileName) {
        List<String> databaseInfo;
        try {
            databaseInfo = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file" + fileName);
        }
        return databaseInfo;
    }
}

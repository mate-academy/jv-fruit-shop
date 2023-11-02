package core.basesyntax.db;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FoodWriteToStoreDaoImpl implements FoodWriteToStoreDao {
    private final Path reportPath;

    public FoodWriteToStoreDaoImpl(Path reportPath) {
        this.reportPath = reportPath;
    }

    @Override
    public void write(List<String> report) {
        try {
            Files.write(reportPath, report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: " + reportPath, e);
        }
    }
}

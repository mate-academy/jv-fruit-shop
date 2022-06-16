package core.basesyntax.db;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static final String FILE_ACTION_PER_DAY = "." + File.separator
                + "src" + File.separator + "main" + File.separator
                + "resources" + File.separator + "ActionsPerDay.csv";
    private static final String FILE_STATISTIC_PER_DAY = "." + File.separator
                + "src" + File.separator + "main" + File.separator
                + "resources" + File.separator + "StatisticPerDay.csv";
    private List<String> lines = new ArrayList<>();

    public List<String> getAllData() {
        try {
            lines = Files.readAllLines(Paths.get(FILE_ACTION_PER_DAY));
        } catch (IOException e) {
            throw new RuntimeException("Cant read file", e);
        }
        return lines;
    }

    public void writeToFile(String text, StandardOpenOption type) {
        File file = new File(FILE_STATISTIC_PER_DAY);
        try {
            Files.write(file.toPath(), text.getBytes(), type);
        } catch (IOException e) {
            throw new RuntimeException("Cant write report to file", e);
        }
    }
}

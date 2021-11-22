package dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReportCsvDaoImpl implements ReportCsvDao {
    private static final String INPUT_FILE_NAME = "input.csv";
    private static final String OUTPUT_FILE_NAME = "output.csv";
    private List<String> input;

    @Override
    public List<String> getActionsOfDay() {
        try {
            input = Files.readAllLines(Path.of(INPUT_FILE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    @Override
    public void setReport(List<String> report) {
        try {
            Files.write(Paths.get(OUTPUT_FILE_NAME), report);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

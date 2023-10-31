package serviceimpl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import service.Writer;

public class WriterImpl implements Writer {
    private static final String FILE_FINDING_PROBLEM = "Can not find file ";
    private static final String PROBLEM_WITH_ARGUMENTS =
            "Invalid arguments: lines or fileName is null";

    public void writeToFile(List<String> lines, String fileName) {
        if (lines == null || fileName == null) {
            throw new IllegalArgumentException(PROBLEM_WITH_ARGUMENTS);
        }
        try (FileWriter writer = new FileWriter(fileName)) {
            for (String line : lines) {
                writer.write(line + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException(FILE_FINDING_PROBLEM + fileName, e);
        }
    }
}

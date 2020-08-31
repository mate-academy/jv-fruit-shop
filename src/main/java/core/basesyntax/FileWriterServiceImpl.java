package core.basesyntax;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FileWriterServiceImpl implements FileWriterService {
    private static final String HEADER = "fruit,quantity";

    @Override
    public void writeFile(Map<String, String> conclusionData, String separator, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(HEADER + "\n");
            for (String key : conclusionData.keySet()) {
                writer.append(key);
                writer.append(separator);
                writer.append(conclusionData.get(key));
                writer.append(System.lineSeparator());
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Wrong fileName", e);
        }
    }
}

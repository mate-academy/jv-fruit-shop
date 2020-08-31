package core.basesyntax;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FileWriterServiceImpl implements FileWriterService {
    private static final String HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public void writeToFile(Map<String, String> conclusionData, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(HEADER + "\n");
            for (String key : conclusionData.keySet()) {
                writer.append(key);
                writer.append(SEPARATOR);
                writer.append(conclusionData.get(key));
                writer.append(System.lineSeparator());
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Wrong fileName", e);
        }
    }
}

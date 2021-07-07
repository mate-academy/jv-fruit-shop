package core.basesyntax;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void writeFile(List<List<String>> conclusionData, String separator, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("fruit,quantity" + "\n");
            for (List<String> strings : conclusionData) {
                for (String str : strings) {
                    writer.append(str);
                    if (strings.indexOf(str) < strings.size() - 1) {
                        writer.append(separator);
                    }
                }
                writer.append(System.lineSeparator());
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Wrong fileName");
        }
    }
}

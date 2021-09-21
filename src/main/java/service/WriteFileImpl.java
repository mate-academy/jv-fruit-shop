package service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

public class WriteFileImpl implements WriteFile {
    public static final String PATH_RESOURCE = "src/main/resources/";

    @Override
    public void writeWithMapToFile(Map<String, Integer> map, String newFileName) {
        String fileNamePath = PATH_RESOURCE + newFileName;
        File file = new File(fileNamePath);
        try (Writer writer = new FileWriter(file)) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                writer.append(entry.getKey())
                        .append(',')
                        .append(entry.getValue().toString())
                        .append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to the file, " + newFileName, e);
        }
    }
}

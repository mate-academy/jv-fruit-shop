package core.basesyntax.file.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class FileWriterImpl implements FileWriterInterface {
    @Override
    public void write(String report, String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resourceUrl = classLoader.getResource(fileName);

        if (resourceUrl == null) {
            throw new RuntimeException("File not found in resources: " + fileName);
        }

        File file = new File(resourceUrl.getPath());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(report);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Error generating file " + file.getAbsolutePath(), e);
        }
    }
}

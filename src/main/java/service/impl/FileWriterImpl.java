package service.impl;

import service.FileWriter;
import java.io.FileOutputStream;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileWriterImpl implements FileWriter {

    @Override
    public void write(String path, String content) {
        File file = new File(path);

        try (BufferedWriter writer =
                     new BufferedWriter(new OutputStreamWriter(
                             new FileOutputStream(file), StandardCharsets.UTF_8))) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Error to write file!" + path);
        }
    }
}

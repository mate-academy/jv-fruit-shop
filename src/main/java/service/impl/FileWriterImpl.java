package service.impl;

import service.FileWriter;

import java.io.FileOutputStream;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileWriterImpl implements FileWriter {
    private static final String OUTPUT_FILE = "src/main/resources/finalReport.csv";

    @Override
    public void write(String path, String content) {
        try (BufferedWriter writer =
                     new BufferedWriter(new OutputStreamWriter(
                             new FileOutputStream(OUTPUT_FILE), StandardCharsets.UTF_8))) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Error to write file!" + path);
        }
    }
}

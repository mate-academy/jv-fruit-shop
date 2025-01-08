package core.basesyntax.utils.impl;

import core.basesyntax.utils.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String line, String filePath) {
        File file = new File(filePath);
        if (!file.getName().endsWith(".csv")) {
            throw new RuntimeException("This is not CSV file!");
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Cannot create file " + file.getAbsolutePath());
            }
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(file));
            bufferedWriter.append(line);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Cannot write to " + file.getAbsolutePath());
        }
    }
}

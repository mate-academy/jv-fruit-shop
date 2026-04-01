package core.basesyntax.file.impl;

import core.basesyntax.file.FileManager;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManagerImpl implements FileManager {
    @Override
    public List<String[]> read(String inputFile) {
        try {
            List<String> data = Files.readAllLines(Path.of(inputFile));
            List<String[]> outputData = new ArrayList<>();

            for (int i = 1; i < data.size(); i++) {
                String[] dataOperation = data.get(i).split(",");
                outputData.add(dataOperation);
            }

            return outputData;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }

    @Override
    public void write(List<String[]> report, String outputFile) {
        File file = new File(outputFile);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write("fruit,quantity");
            bufferedWriter.flush();

            for (String[] data : report) {
                bufferedWriter.newLine();
                bufferedWriter.write(data[0] + "," + data[1]);
                bufferedWriter.flush();
            }

        } catch (IOException e) {
            throw new RuntimeException("Can't write file", e);
        }
    }
}

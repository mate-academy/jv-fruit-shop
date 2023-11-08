package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;

public class FileWriterImpl implements FileWriter {
    private static final String HEAD_OF_REPORT = "fruit,quantity";

    @Override
    public void writeToFile(Map<String, Integer> map, String fileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(fileName))) {
            bufferedWriter.write(HEAD_OF_REPORT);
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                bufferedWriter.newLine();
                bufferedWriter.write(entry.getKey() + "," + entry.getValue());
            }
            System.out.println("Write to file successful");
        } catch (IOException e) {
            throw new RuntimeException("Cant write file");
        }
    }
}

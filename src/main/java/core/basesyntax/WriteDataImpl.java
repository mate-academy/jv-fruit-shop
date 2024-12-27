package core.basesyntax;

import java.io.*;
import java.util.List;

public class WriteDataImpl implements WriteData {
    private final String newPath;

    public WriteDataImpl(String newPath) {
        this.newPath = newPath;
    }

    @Override
    public File writeData(List<String> processedList) {
        File file = new File(newPath);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write("fruit,quantity");
            bufferedWriter.newLine();
            for (String string : processedList) {
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can not write data to a file", e);
        }
        return file;
    }
}

package service.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteFileImpl implements WriteFile {
    static final String TITLE_OF_REPORT = "fruit,quantity";

    @Override
    public void writeListToFile(List<String> report, File file) {
        List<String> wrap = new ArrayList<>();
        wrap.add(TITLE_OF_REPORT);
        wrap.addAll(report);

        for (String line:wrap) {
            try (BufferedWriter bufferedWriter
                         = new BufferedWriter(new FileWriter(file,true))) {
                bufferedWriter.write(line);
                bufferedWriter.write(System.lineSeparator());

            } catch (IOException e) {
                throw new RuntimeException("Can't write report to file: " + file, e);

            }
        }
    }
}

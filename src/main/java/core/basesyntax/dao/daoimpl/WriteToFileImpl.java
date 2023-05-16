package core.basesyntax.dao.daoimpl;

import core.basesyntax.dao.WriteToFile;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFileImpl implements WriteToFile {

    @Override
    public void writeToFile(String report, String toFile) {
        File file1 = new File(toFile);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file1))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file: " + toFile, e);
        }
    }
}

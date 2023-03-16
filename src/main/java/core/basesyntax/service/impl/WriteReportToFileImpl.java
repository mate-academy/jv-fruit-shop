package core.basesyntax.service.impl;

import core.basesyntax.service.GenerateStringToWrite;
import core.basesyntax.service.WriteReportToFile;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteReportToFileImpl implements WriteReportToFile {
    private GenerateStringToWrite generateStringToWrite = new GenerateStringToWriteImpl();

    @Override
    public void writeData(Map<String, Integer> fruits, String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(generateStringToWrite.stringToWrite(fruits));
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file");
        }
    }
}

package core.basesyntax.service.impl;

import core.basesyntax.service.DataWriterService;
import core.basesyntax.service.ReportMakerService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class DataWriterServiceImpl implements DataWriterService {
    private ReportMakerService generateStringToWrite = new ReportMakerServiceImpl();

    @Override
    public void writeData(Map<String, Integer> fruits, String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(generateStringToWrite.createReportString(fruits));
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file");
        }
    }
}

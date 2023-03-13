package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(List<String> records, String filePath) {
       /* List<String> collect = records.stream()
               .map(s->s::convertToCSV)
                .collect(Collectors.toList());*/

        // CSV is a normal text file, need a writer
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String record : records) {
                bw.write(record);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("There is IOException: ", e);
        }
    }

  /*  public String convertToCSV(List<String> data) {
        return data.stream()
                .collect(Collectors.joining(","));
    }*/

}

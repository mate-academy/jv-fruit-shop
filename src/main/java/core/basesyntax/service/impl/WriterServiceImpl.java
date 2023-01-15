package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(List<String> reportLines, String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            Iterator<String> iterator = reportLines.iterator();
            bufferedWriter.write(iterator.next());
            while (iterator.hasNext()) {
                bufferedWriter.newLine();
                bufferedWriter.write(iterator.next());
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot write to the file", e);
        }        
    }
}

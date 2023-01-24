package core.basesyntax.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.WriterService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;

public class WriterServiceImpl implements WriterService {

    @Override
    public void writeFile(String filePath) {
        File csvOutputFile = new File(filePath);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            pw.println("fruit,quantity");
            for (Map.Entry<String, Integer> entry : Storage.fruitsStorage.entrySet()) {
                pw.println(entry.getKey() + "," + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't create file " + filePath);
        }
    }
}

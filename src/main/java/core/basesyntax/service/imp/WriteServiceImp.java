package core.basesyntax.service.imp;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WriteServiceImp implements WriterService {
    @Override
    public void writeToFile(HashMap<String, Integer> balance) {
        final String outputFilePath = "src/main/java/core/basesyntax/db/report.csv";
        File file = new File(outputFilePath);
        BufferedWriter bf;
        try {
            bf = new BufferedWriter(new FileWriter(file));
        } catch (IOException e) {
            throw new RuntimeException("I can't create file in this directory");
        }
        for (Map.Entry<String, Integer> entry :
                balance.entrySet()) {
            try {
                bf.write(entry.getKey() + ","
                        + entry.getValue());
                bf.newLine();
            } catch (IOException e) {
                throw new RuntimeException("I can't made new line in this directory");
            }
        }
        try {
            bf.close();
        } catch (IOException e) {
            throw new RuntimeException("I can't close this file in this directory");
        }
    }
}

package core.basesyntax.workwithfiles;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriterImpl implements Writer {
    @Override
    public void write(Map<String, Integer> mapWithResults, String newFileName) {
        File file = new File(newFileName);
        BufferedWriter bufferedWriter;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file,true));
            bufferedWriter.write("fruit;quantity");
            for (Map.Entry<String, Integer> entry : mapWithResults.entrySet()) {
                bufferedWriter.write("\n" + entry.getKey() + ";" + entry.getValue());
            }
            bufferedWriter.write("\n");
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + "newFileName", e);
        }
    }
}

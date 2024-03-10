package core.basesyntax.workwithfiles;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterImpl implements Writer {
    @Override
    public void write(String finalData, String newFileName) {
        File file = new File(newFileName);
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true));
            bufferedWriter.write(finalData);
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + newFileName, e);
        }
    }
}

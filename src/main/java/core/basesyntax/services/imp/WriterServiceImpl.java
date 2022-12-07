package core.basesyntax.services.imp;

import core.basesyntax.services.FileWriteService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements FileWriteService {
    @Override
    public void writeReportToFile(String filePath, String text) {
        File file = new File(filePath);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true))) {
            file.createNewFile();
            bufferedWriter.write(text);
        } catch (IOException e) {
            throw new RuntimeException("Cant write text to file",e);
        }
    }
}

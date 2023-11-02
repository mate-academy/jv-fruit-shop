package core.basesyntax.service.imp;

import core.basesyntax.service.FileWriteService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileWriteServiceImp implements FileWriteService {
    @Override
    public void writeCvsToFile(List<String> text, String path) {
        File file = new File(path);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (String str : text) {
                bufferedWriter.write(str);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write file" + path, e);
        }
    }
}

package core.basesyntax.dto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CustomWriterFileImp implements CustomWriterFile {
    @Override
    public boolean writeFile(String nameFile, String text) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(nameFile))) {
            bufferedWriter.append(text);
        } catch (IOException e) {
            throw new RuntimeException("Can't write file", e);
        }
        return true;
    }
}

package core.basesyntax.service.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterHandlerImpl implements FileWriterHandler {

    @Override
    public void writeToFile(String fromSting) {
        File fileForRaport = new File("raport.csv");
        try (FileWriter fileWriter = new FileWriter(fileForRaport)) {
            fileWriter.write(fromSting);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file", e);
        }
    }

}

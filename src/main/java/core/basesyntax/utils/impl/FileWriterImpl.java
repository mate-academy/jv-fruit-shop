package core.basesyntax.utils.impl;

import core.basesyntax.utils.FileWriter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class FileWriterImpl implements FileWriter {
    public void writeToFile(String fileName, List<String> data) {
        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create file: " + fileName, e);
        }

        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyy / HH:mm:ss", Locale.getDefault());
            LocalDateTime localDateTime = LocalDateTime.now();
            Files.write(Paths.get(file.getPath()), data);
            System.out.println("Finish: " + localDateTime.format(dtf) + System.lineSeparator()
                    + "file name: '" + fileName + "' - save success !!");
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data to file: " + fileName, e);
        }
    }
}

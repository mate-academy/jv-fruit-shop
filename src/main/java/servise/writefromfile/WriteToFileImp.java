package servise.writefromfile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteToFileImp implements WriteToFile {
    @Override
    public void writeToFile(Path path, String report) {
        try {
            Files.writeString(path, report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write text in file" + path, e);
        }
    }
}

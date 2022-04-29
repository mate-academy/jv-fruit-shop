package servise.writefromfile;

import java.nio.file.Path;

public interface WriteToFile {
    void writeToFile(Path path, String report);
}

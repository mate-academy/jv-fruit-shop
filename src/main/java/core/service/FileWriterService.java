package core.service;

import java.io.File;

public interface FileWriterService {
    boolean writeToFile(File file, String data);
}

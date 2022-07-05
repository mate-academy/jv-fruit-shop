package core.service;

import java.io.File;

public interface FileWriterService {
    boolean write(File file, String data);
}

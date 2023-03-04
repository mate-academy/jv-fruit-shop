package fileservice;

import java.util.List;

public interface FileService {
    List read(String file);

    void write(String file, String content);
}

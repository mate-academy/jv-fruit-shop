package core.shop.service;

import java.util.List;

public interface FileService {
    List<String> read(String filename);

    void write(String fileName, String info);
}

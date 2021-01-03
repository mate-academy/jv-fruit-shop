package store.service.files;

import java.util.List;

public interface ReadWriteAble {
    void read();

    List<String> readFromTempFile();

    String writeToReport();

    void startWork();
}

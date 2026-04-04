package core.io;

import java.util.Map;

public interface Writer {
    void writeData(String fileName, Map<String, Integer> data);
}

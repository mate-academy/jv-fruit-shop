package dao;

import java.util.Map;

public interface Writer {
    void reportWriter(Map<String, Integer> reportMap, String filePath);
}

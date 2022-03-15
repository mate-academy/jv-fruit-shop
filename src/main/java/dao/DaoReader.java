package dao;

import java.util.List;

public interface DaoReader {
    List<String> get(String fileName);
}

package service;

import java.util.List;

public interface FileWriterService {
    boolean write(List<String> statistic, String filePath);
}

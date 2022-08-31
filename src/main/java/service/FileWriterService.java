package service;

import java.io.File;
import java.util.List;

public interface FileWriterService {
    File writeToFile(List<String> toWriteData);
}

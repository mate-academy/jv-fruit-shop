package service;

import java.io.File;
import java.util.List;

public interface FileWriterService {

    File saveToFile(File reportFile, List<String> report);
}

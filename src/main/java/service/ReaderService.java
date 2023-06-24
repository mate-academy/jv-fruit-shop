package service;

import java.io.File;
import java.util.List;

public interface ReaderService {
    public List<String> read(File inputFileName);
}

package services;

import java.util.List;
import model.Product;

public interface WriterService {
    void writeToFile(String toFile, String report);
}

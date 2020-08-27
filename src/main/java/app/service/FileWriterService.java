package app.service;

import app.model.Fruit;
import java.util.List;

public interface FileWriterService {
    boolean writeData(List<Fruit> fruits, String filePath);
}

package app.service;

import app.model.SupplyFruit;
import java.util.List;

public interface FileWriterService {
    boolean writeData(List<SupplyFruit> fruits, String filePath);
}

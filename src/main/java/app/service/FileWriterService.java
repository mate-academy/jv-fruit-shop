package app.service;

import app.model.SupplyFruitBatch;
import java.util.List;

public interface FileWriterService {
    boolean writeData(List<SupplyFruitBatch> fruits, String filePath);
}

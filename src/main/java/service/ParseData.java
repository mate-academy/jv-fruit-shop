package service;

import java.util.List;
import model.FruitRecord;

public interface ParseData {
    List<FruitRecord> recordingData(List<String[]> splitedInformationList);
}

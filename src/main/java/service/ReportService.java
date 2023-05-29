package service;

import db.FruitsStorage;
import model.OutFileStructure;

public interface ReportService {
    String getDataReport(OutFileStructure structure, FruitsStorage storage);
}

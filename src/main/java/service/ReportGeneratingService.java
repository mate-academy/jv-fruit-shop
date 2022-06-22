package service;

import java.util.List;
import model.Fruit;

public interface ReportGeneratingService {

    List<String> createReport(List<Fruit> db);
}

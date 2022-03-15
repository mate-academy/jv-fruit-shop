package service;

import java.util.List;
import model.Fruit;

public interface ReportCreator {
    String createReport(List<Fruit> fruits);
}

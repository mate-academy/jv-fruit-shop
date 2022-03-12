package service;

import model.Fruit;

import java.util.List;

public interface ReportCreator {
    String createReport(List<Fruit> fruits);
}

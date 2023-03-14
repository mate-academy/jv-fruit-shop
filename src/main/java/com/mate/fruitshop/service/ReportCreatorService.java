package com.mate.fruitshop.service;

import com.mate.fruitshop.model.FruitEntry;
import java.util.List;

public interface ReportCreatorService {
    String createReport(List<FruitEntry> fruits);
}

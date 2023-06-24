package core.service;

import java.util.List;
import java.util.Map;

public interface ReportSevice {
    List<String> reportGenerator(Map<String, Integer> fruits);
}

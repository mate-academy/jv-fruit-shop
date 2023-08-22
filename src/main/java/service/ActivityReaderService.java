package service;

import java.util.List;
import model.Activity;

public interface ActivityReaderService {
    List<Activity> readFromFile(String fileName);
}

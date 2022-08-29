package service;

import java.util.List;
import model.Fruits;

public interface ParserService {
    List<Fruits> parse(List<String> input);
}

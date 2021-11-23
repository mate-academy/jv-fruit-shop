package service;

import java.util.List;

public interface MyParser<T> {
    List<T> parseLine(List<String> line);
}

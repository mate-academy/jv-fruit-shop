package service;

import java.util.List;

public interface MyParser<T> {
    List<T> parseLines(List<String> lines);
}

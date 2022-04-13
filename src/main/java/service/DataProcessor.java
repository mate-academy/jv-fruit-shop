package service;

public interface DataProcessor<J, K> {
    K process(J data);
}

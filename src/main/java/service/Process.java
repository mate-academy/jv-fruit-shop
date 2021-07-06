package service;

public interface Process<J, K> {
    K process(J data);
}

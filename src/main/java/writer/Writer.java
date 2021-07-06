package writer;

public interface Writer<I, K, J> {
    String write(K writeTo, J data);
}

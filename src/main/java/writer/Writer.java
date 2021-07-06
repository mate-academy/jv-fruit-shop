package writer;

public interface Writer<I, K, J> {
    String write(I index, K writeTo, J data);
}

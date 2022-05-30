import java.lang.Exception;
public class NegativeIndexException extends Exception {

    public NegativeIndexException(int index) {
        super("Negative index is not allowed " + index);
    }

}
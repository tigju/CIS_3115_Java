import java.lang.Exception;
public class MinValueException extends Exception {

    public MinValueException(String str, int value) {
        super("Error occured: " + str + " " + value);
    }
}

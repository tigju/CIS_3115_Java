import java.lang.Exception;
public class CustomOutOfBoundException extends Exception {

    public CustomOutOfBoundException(int[] arr) {
        super("Array out of bounds. Array length is " + arr.length);
    }

}

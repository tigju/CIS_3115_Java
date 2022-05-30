import java.lang.Math;

public class MainOperator extends BasicOperator implements MathOperator {

    @Override
    public float add(float number1, float number2) {
        // TODO Auto-generated method stub
        return number1 + number2;

    }

    @Override
    public float minus(float number1, float number2) {
        // TODO Auto-generated method stub
        return number1 - number2;
    }

    @Override
    public float divide(float number1, float number2) {
        // TODO Auto-generated method stub
        return number1 / number2;
    }

    @Override
    public float multiply(float number1, float number2) {
        // TODO Auto-generated method stub
        return number1 * number2;
    }

    @Override
    public float square(float number1) {
        // TODO Auto-generated method stub
        return number1 * number1;
    }

    @Override
    public float root(float number1) {
        // TODO Auto-generated method stub
        return (float) Math.sqrt(number1);
    }

    public float factorial(float number1) {
        // TODO Auto-generated method stub
        if (number1 ==0) {
            return 1;
        }
        else {
            return number1 * factorial(number1 - 1);
        }
    }

    @Override
    public float absolute(float number1) {
        // TODO Auto-generated method stub
        return Math.abs(number1);
    }

}

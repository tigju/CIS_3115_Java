public class TestSquare {

    public static void main(String[] args) {

        Point point1 = new Point(2,2);
        Square square1 = new Square(point1, 4);

        square1.toStr();

        for (int i =0; i < square1.getSquareCorners().length; i++){
            System.out.println("Point " + i + " : (" + square1.getSquareCorners()[i].getX() + ","+ square1
                    .getSquareCorners()[i].getY() +")");
        }

        Square square_a = new Square(new Point(5, 5), 1.5);
        Square square_b = new Square(new Point(1, 1), 3);
        Square square_c = new Square(new Point(1, 1), 2);
        //Square square_d = new Square(new Point(3, 3), 6);
        Square[] squares = { square_a, square_b, square_c};

        for (int i = 0; i < squares.length; i++) {
            System.out.println("Square #"+i);
            squares[i].toStr();
        }

        for (int i = 0; i < squares.length; i++) {
            System.out.println("Area between square1 and Square #" + i);
            System.out.println(square1.getOverLappingArea(squares[i]));
        }


    }
}
public class TestSquare {

    public static void main(String[] args) {

        // Object without argument
        Square square1 = new Square(); // side = 10
        System.out.println("Square 1 side " + square1.side);
        System.out.println("Square 1 Area: " + square1.getArea());
        System.out.println("Square 1 Perimeter: " + square1.getPerimeter() + "\n");

        square1.setSide(20);
        System.out.println("Square 1 new side " + square1.side);
        System.out.println("Square 1 new Area: " + square1.getArea());
        System.out.println("Square 1 new Perimeter: " + square1.getPerimeter() + "\n");

        // Object with argument
        Square square2 = new Square(40);
        System.out.println("Square 2 side " + square2.side);
        System.out.println("Square 2 Area: " + square2.getArea());
        System.out.println("Square 2 Perimeter: " + square2.getPerimeter() + "\n");

        square2.setSide(80);
        System.out.println("Square 2 new side " + square2.side);
        System.out.println("Square 2 new Area: " + square2.getArea());
        System.out.println("Square 2 new Perimeter: " + square2.getPerimeter() + "\n");

        // New object with central point
        Square square3 = new Square(new int[]{5,5}, 3);
        System.out.println("Central Point coordinates of Square 3 are (" + 
                            square3.centralPoint[0] +", "+ 
                            square3.centralPoint[1] + ")\n");
        // set a side and set central point
        square3.setSide(2);
        square3.setCentralPoint(new int[]{1,1});
        System.out.println(
                "New Central Point coordinates of Square 3 are (" +
                square3.centralPoint[0] + ", " + 
                square3.centralPoint[1] + ")\n");
        
        System.out.println("Distance between center an point (5,4) is "+
                            square3.getDistance(new int[]{5,4}) + "\n");
        
        int [][] squarePoints = square3.getSquareCorners();
        System.out.println("Four corner points of Square 3: \n");
        for(int i = 0; i< squarePoints.length; i++) {
            System.out.print("(" + squarePoints[i][0] + ", "+ squarePoints[i][1] + "), ");

        }
    }
}
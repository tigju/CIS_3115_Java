public class TestSquare{

    public static void main(String[] args){
        
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
        System.out.println("Square 2 new Perimeter: " + square2.getPerimeter());
    }
}
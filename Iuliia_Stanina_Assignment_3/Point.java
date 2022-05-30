public class Point {
    
    private double x = 0;
    private double y = 0;

    Point(){
    
    }

    // constractor with one arg side
    Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    
    double getX() {
        return x;
    }

    double getY() {
        return y;
    }

    void setX(double x) {
        this.x = x;
    }

    void setY(double y) {
        this.y = y;
    }

    double getDistance(Point a) {
        double distance = Math.sqrt(Math.pow(a.x - this.x, 2) + Math.pow(
                a.y - this.y, 2));
        return distance;
    }

    String toStr() {
        return "Point information: x= " + this.x + ", " + "y=" + this.y + "\n";
    }
}

public class Point2D {

    private int x = 0;
    private int y = 0;

    Point2D(){
    
    }

    // constractor with one arg side
    Point2D(int x, int y){
        this.x = x;
        this.y = y;
    }

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }

    void setX(int x) {
        this.x = x;
    }

    void setY(int y) {
        this.y = y;
    }

    double getDistance(Point2D a) {
        double distance = Math.sqrt(Math.pow(a.x - this.x, 2) + Math.pow(
                a.y - this.y, 2));
        return distance;
    }

    String toStr() {
        return "Point information: x= " + this.getX() + ", " + "y=" + this.getY();
    }

}

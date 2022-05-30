public class Point3D extends Point2D {

    private int z = 0;
    
    Point3D(){
        super();
    }

    Point3D(int x, int y, int z){
        super(x, y);
        this.z = z;
    }

    // setters
    void setX(int x) {
        super.setX(x);
    }

    void setY(int y) {
        super.setY(y);
    }

    void setZ(int z) {
        this.z = z;
    }

    // getters
    int getX() {
        return super.getX();
    }

    int getY() {
        return super.getY();
    }

    int getZ() {
        return this.z;
    }

    double getDistance(Point3D a) {
        double distance = Math.sqrt(Math.pow(a.getX() - this.getX(), 2) + Math.pow(
                a.getY() - this.getY(), 2) + Math.pow(a.getZ() - this.getZ(), 2));
        return distance;
    }

    public String toStr() {
        return super.toStr() + " z=" + this.getZ();

    }

}

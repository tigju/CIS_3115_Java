class Square{

    private double side;
    private Point centralPoint = new Point();

    // constractor without args
    Square(){
        side = 10;
    }

    // constractor with one arg side
    Square(double side){
        this.side = side; 
    }

    // // constractor with two args side and central point
    Square(Point centralPoint, double side) {
        this.side = side;
        this.centralPoint = centralPoint;
    }

    // // constractor with one arg central point
    Square(Point centralPoint) {
        this.centralPoint = centralPoint;
    }
    
    void setSide(int newSide){
        side = newSide; 
    }

    //  area, perimeter, toString methods
    double getArea(){
        return this.side*this.side;
    }
    double getPerimeter(){
        return this.side*4;
    }

    // set central point
    public void setCentralPoint(Point centralPoint) {
        this.centralPoint = centralPoint;
    }

    // return central point
    Point getCentralPoint(){
        return this.centralPoint;
    }

    // euclidean distance
    public double getDistance(Point otherPoint){
        double distance = this.centralPoint.getDistance(otherPoint);
        return distance;
    }

    public Point[] getSquareCorners(){
        // If the central point is [1,1], side is 2:
        // top left corner: 1-(2/2), 1+(2/2) = [0,2]
        // top right corner: 1+(2/2), 1+(2/2) = [2,2]
        // bottom right corner: 1+(2/2), 1-(2/2) = [2,0]
        // bottom left corner: 1-(2/2), 1-(2/2) = [0,0]
        Point top_left = new Point(this.centralPoint.getX() - (this.side/2), this.centralPoint.getY() + (this.side/2));
        Point top_right = new Point(this.centralPoint.getX() + (this.side/2), this.centralPoint.getY() + (this.side/2));
        Point bottom_right = new Point(this.centralPoint.getX() + (this.side/2), this.centralPoint.getY() - (this.side/2));
        Point bottom_left = new Point(this.centralPoint.getX() - (this.side/2), this.centralPoint.getY() - (this.side/2));
        Point[] corners = {top_left, top_right, bottom_right, bottom_left};
                        
        return corners;
    }

    void toStr() {
        System.out.println("Square information: \n central point information: x=" + 
        this.centralPoint.getX() + ", " + "y=" + this.centralPoint.getY() + 
        ", side=" + this.side + "\n");
    }

    // works only for specific cases 
    double getOverLappingArea(Square a) {
        Point[] sq1 = this.getSquareCorners();
        Point[] sq2 = a.getSquareCorners();
        double area = 0;

        // check if new square is inside square1
        if (sq1[0].getX() >= sq2[0].getX() 
            && sq1[0].getY() >= sq2[0].getY() 
            && sq1[1].getX() >= sq2[1].getX()
            && sq1[1].getY() >= sq2[1].getY()
            && sq1[2].getX() >= sq2[2].getX() 
            && sq1[2].getY() <= sq2[2].getY() 
            && sq1[3].getX() <= sq2[3].getX()
            && sq1[3].getY() <= sq2[3].getY()) {
            return a.getArea();
        } 

        // check if square1 is inside a new square
        if (sq1[0].getX() <= sq2[0].getX()
            && sq1[0].getY() <= sq2[0].getY()
            && sq1[1].getX() <= sq2[1].getX()
            && sq1[1].getY() <= sq2[1].getY()

            && sq1[2].getX() <= sq2[2].getX()
            && sq1[2].getY() >= sq2[2].getY()

            && sq1[3].getX() >= sq2[3].getX()
            && sq1[3].getY() >= sq2[3].getY()) {
            return this.getArea();
        }
        
        // check if square1 not overlap
        if (sq1[3].getX() > sq2[1].getX() 
            || sq1[3].getY() > sq2[1].getY()
            || sq2[3].getX() > sq1[1].getX()
            || sq2[3].getY() > sq2[1].getY() ) 
            return area;
        
        // works only for specific case, needs imporvement
        if (sq1[3].getX() < sq2[1].getX() // sq1 top-right x < sq2 bottom-left x
                || sq1[3].getY() < sq2[1].getY()) // sq1 top-right y < sq2 bottom-left y
                {
                double distance = Math.sqrt(Math.pow(sq2[1].getX() - sq1[3].getX(), 2) + Math.pow(
                sq2[1].getY() - sq1[3].getY(), 2));
                return Math.pow(distance, 2)/2;
                }
            
        return area;
    }

}
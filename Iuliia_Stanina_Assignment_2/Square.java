class Square{

    int side;
    public int[] centralPoint = new int[]{0,0};

    // constractor without args
    Square(){
        side = 10;
    }

    // constractor with one arg side
    Square(int newSide){
        side = newSide; 
    }

    // // constractor with two args side and central point
    Square(int[] newCentralPoint, int newSide) {
        side = newSide;
        centralPoint = newCentralPoint;
    }

    // // constractor with one arg central point
    Square(int[] newCentralPoint) {
        centralPoint = newCentralPoint;
    }
    
    void setSide(int newSide){
        side = newSide; 
    }

    //  area, perimeter, toString methods
    int getArea(){
        return side*side;
    }
    int getPerimeter(){
        return side*4;
    }

    // set central point
    public void setCentralPoint(int[] newCentralPoint) {
        centralPoint = newCentralPoint;
    }

    // return central point
    int[] getCentralPoint(){
        return centralPoint;
    }

    // euclidean distance
    public double getDistance(int[] otherPoint){
        double distance = Math.sqrt(Math.pow(centralPoint[1] - otherPoint[1] ,2) + Math.pow(
                centralPoint[0] - otherPoint[0], 2) );
        return distance;
    }

    public int[][] getSquareCorners(){
        // If the central point is [1,1], side is 2:
        // top left corner: 1-(2/2), 1+(2/2) = [0,2]
        // top right corner: 1+(2/2), 1+(2/2) = [2,2]
        // bottom right corner: 1+(2/2), 1-(2/2) = [2,0]
        // bottom left corner: 1-(2/2), 1-(2/2) = [0,0]
        int[][] corners = {{centralPoint[0] - (side/2), centralPoint[1] + (side/2)}, 
                        {centralPoint[0] + (side/2), centralPoint[1] + (side/2)}, 
                        {centralPoint[0] + (side/2), centralPoint[1] - (side/2)}, 
                        { centralPoint[0] - (side/2), centralPoint[1] - (side/2)}};
        return corners;
    }

}
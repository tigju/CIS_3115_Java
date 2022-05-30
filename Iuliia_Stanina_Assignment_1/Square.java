class Square{

    double side;
    
    Square(){
        side = 10;
    }
    
    Square(double newSide){
        side = newSide; 
    }
    
    void setSide(double newSide){
        side = newSide; 
    }

    //  area, perimeter, toString methods
    double getArea(){
        return side*side;
    }
    double getPerimeter(){
        return side*4;
    }

}
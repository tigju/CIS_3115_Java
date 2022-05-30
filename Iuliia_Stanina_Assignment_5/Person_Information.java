public class Person_Information {
    
    private double age = 0;
    private double height = 0;
    private double weight = 0;

    Person_Information(double age, double height, double weight) {
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    double getAge(){
        return this.age;
    }

    double getHeight() {
        return this.height;
    }

    double getWeight() {
        return this.weight;
    }

    void setAge(double age) {
        this.age = age;
    }

    void setHeight(double height) {
        this.height = height;
    }

    void setWeight(double weight) {
        this.weight = weight;
    }

    double getBMI(){
        double  KILOGRAMS_PER_POUND = 0.45359237; 
        double METERS_PER_INCH = 0.0254;
        double new_weight = weight*KILOGRAMS_PER_POUND;
        double new_height = height*METERS_PER_INCH;
        double bmi = new_weight/(Math.pow(new_height, 2));
        return bmi;
    }

    String getBMIStatus(){
        double bmi = this.getBMI();
        String res = "";
        if(bmi <18.5)
            res ="Underweight";
        else if(bmi<=24.9)
            res = "Healthy";
        else if(bmi<=29.9)
            res = "Overweight";
        else
            res = "Obese";

        return res;
    }

    String toStr() {
        return "Person Information => Age: " + this.age + ", Height: " + this.height + ", Weight: " + this.weight + "\n";
    }
}

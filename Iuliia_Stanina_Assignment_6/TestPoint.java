import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class TestPoint {  
    public static void main(String[] args) {  

        // for all points
        ArrayList<Point2D> p2d = new ArrayList<>();
        ArrayList<Point3D> p3d = new ArrayList<>();

        // for distinct points
        HashSet<String> p2_hash = new HashSet<>();
        HashSet<String> p3_hash = new HashSet<>();

        try {
            File myObj = new File("data.txt");
            Scanner myReader = new Scanner(myObj);
            

            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();
                String[] str = data.split(",");
                
                if (str.length > 2) {
                    // add distinct point to set
                    p3_hash.add(data);
                    // parse data to int
                    Integer x = Integer.parseInt(str[0].trim().split("=")[1]);
                    Integer y = Integer.parseInt(str[1].trim().split("=")[1]);
                    Integer z = Integer.parseInt(str[2].trim().split("=")[1]);
                    Point3D p3 = new Point3D(x,y,z);
                    // all points
                    p3d.add(p3);
                }
                else {
                    // add distinct point to set
                    p2_hash.add(data);
                    // parse data to int
                    Integer x = Integer.parseInt(str[0].trim().split("=")[1]);
                    Integer y = Integer.parseInt(str[1].trim().split("=")[1]);
                    Point2D p2 = new Point2D(x,y);
                    // all points
                    p2d.add(p2); 
                }
                
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } 

        // get distinct points strings and store them in objects
        ArrayList<Point2D> disc_2d = new ArrayList<>();
        for (String s : p2_hash){
            String[] temp = s.split(",");
            Integer x = Integer.parseInt(temp[0].trim().split("=")[1]);
            Integer y = Integer.parseInt(temp[1].trim().split("=")[1]);
            Point2D p2 = new Point2D(x, y);
            disc_2d.add(p2);
        }

        // get distinct points strings and store them in objects
        ArrayList<Point3D> disc_3d = new ArrayList<>();
        for (String s : p3_hash) {
            String[] temp = s.split(",");
            Integer x = Integer.parseInt(temp[0].trim().split("=")[1]);
            Integer y = Integer.parseInt(temp[1].trim().split("=")[1]);
            Integer z = Integer.parseInt(temp[2].trim().split("=")[1]);
            Point3D p2 = new Point3D(x, y, z);
            disc_3d.add(p2);
        }


        // total 2d and 3d points 
        System.out.println("========================================");
        System.out.println("How many total 2D points?");
        System.out.println(p2d.size());
        System.out.println("How many total 3D points?");
        System.out.println(p3d.size());
        System.out.println("========================================");
        // distinct 2d and 3d points
        System.out.println("How many distinct 2D points?");
        System.out.println(p2_hash.size());
        System.out.println("How many distinct 3D points?");
        System.out.println(p3_hash.size());
        System.out.println("========================================");

        // create 2D Point
        Point2D point_a = new Point2D(-1, 1);

        // create 3D Point
        Point3D point_b = new Point3D(0, 10, -5);



        BigDecimal sum_2d = new BigDecimal(0);

        System.out.println("Distances between 2D points and point_a: \n");
        // distinct 2D points distance with point_a
        for(Point2D p : disc_2d){
            BigDecimal d = new BigDecimal(p.getDistance(point_a));
            sum_2d = sum_2d.add(d);
            System.out.println(p.toStr() + " and " + point_a.toStr() + " distance is " + d);
        }
        System.out.println("========================================");
        
        BigDecimal sum_3d = new BigDecimal("0");

        System.out.println("Distances between 3D points and point_b: \n");
        // distinct 3D points distance with point_a
        for (Point3D p : disc_3d) {
            BigDecimal d = new BigDecimal(p.getDistance(point_b));
            sum_3d = sum_3d.add(d);
            System.out.println(p.toStr() + " and " + point_b.toStr() + " distance is " + d);
        }

        System.out.println("========================================");
        // print sum of all distinct 2d points
        System.out.println("The sum of distinct 2D points is " + sum_2d);
        // print sum of all distinct 3d points
        System.out.println("The sum of distinct 3D points is " + sum_3d);

    }  
} 
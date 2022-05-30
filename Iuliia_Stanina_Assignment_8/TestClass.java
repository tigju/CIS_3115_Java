import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) {
        // create default array 
        DynamicArray e = new DynamicArray();
        // create reader
        Scanner scan = new Scanner(System.in);
        
        int num = 0;
        while(num != 5) {
            System.out.println("------Menu------\n");
            System.out.println("1. add number\n2. get number\n3. remove number\n4. print DynamicArray\n5. exit\n");
            System.out.print("Enter Your Choice: ");
            num = scan.nextInt();
            switch (num) {
                case 1:
                    System.out.print("Enter Your index: ");
                    int index = scan.nextInt();
                    System.out.print("Enter Your value: ");
                    int value = scan.nextInt();
                    try {
                        e.setElement(index, value);
                        System.out.println("value " + value + " added to index "+ index);
                    } catch (ArithmeticException r) {
                        System.out.println(r);
                    }
                    break;
                case 2:
                    System.out.print("Enter Your index: ");
                    int indx = scan.nextInt();
                    try {
                        e.getElement(indx);     
                    } catch (ArithmeticException r) {
                        System.out.println(r);
                    }
                    break;
                case 3:
                    System.out.print("Enter Your index: ");
                    int ind = scan.nextInt();
                    try {
                        e.removeElement(ind);
                    } catch (ArithmeticException r) {
                        System.out.println(r);
                    }
                    break;
                case 4:
                    System.out.println(e.printInfo());
                    break;
                case 5:
                    System.out.println("exiting...\nDone\n");
                    num = 5;
                    break;
                default:
                    num = 0;
            }
        }
        scan.close();
    }
    
}

import java.util.*;

class StackOfIntegers {
    // array, size default capacity

    private int[] elements;
    private int size;

    public static final int DEFAULT_CAPACITY = 16;

    StackOfIntegers() {
        this.elements = new int[DEFAULT_CAPACITY];
        this.size = 0;

    }

    StackOfIntegers(int newCapacity) {
        this.elements = new int[newCapacity];
        this.size = 0;

    }

    // empty

    public boolean empty() {

        return this.size == 0;

    }

    // pop
    public int pop() {

        return elements[--size];

    }

    // peek
    public int peek() {
        int t = size;
        return elements[--t];

    }

    // push

    public void push(int value) {
        if (this.size == elements.length) {

            int[] arr = new int[size * 2];

            for (int i = 0; i < size; i++) {
                arr[i] = elements[i];
            }
            arr[size++] = value;

            elements = arr;

        } else {
            elements[size++] = value;
        }

    }

    // getSize()

    public int getSize() {

        return this.size;

    }

    public void toCopy(StackOfIntegers stack){
        this.size = stack.getSize();
        this.elements = new int[stack.elements.length];
        for (int i = 0; i < stack.elements.length; i++)
            this.elements[i] = stack.elements[i];
    }

    public void toClear() {
        this.size = 0;
        int l = this.elements.length;
        this.elements = new int[l];
    }
    

    public int getMax() {
        int result = this.elements[0];
        for (int i = 1; i < this.elements.length; ++i) {
            if (result < this.elements[i])
                result = this.elements[i];
        }
        return result;
    }

    public int getMin() {
        int result = this.elements[0];
        for (int i = 1; i < this.size; ++i) {
            if (result > this.elements[i])
                result = this.elements[i];
        }
        return result;
    }
    ArrayList<Integer> getDuplicate() {
        ArrayList<Integer> results = new ArrayList<>();
        HashMap<Integer, Integer> duplicates = new HashMap<>();
        
        for (int num: this.elements)  {
            if (duplicates.containsKey(num)) {
                results.add(num);
            }
            else {
                 duplicates.put(num, 1);
            }

        }
        int num_of_dup = 0;
        for (int i: results){
            if (i > 0) {
                num_of_dup++;
            }
        }
        if (num_of_dup > 0){
            return results; 
        }
        else {
            System.out.println("No duplicates");
            return results;
        }

        
    }

    public static void main(String[] args) {
        StackOfIntegers stack = new StackOfIntegers();

        for (int i = 0; i < 20; i++)
            stack.push(i);

        System.out.println("Stack 1 ");
        System.out.println("----------");
        System.out.println("Max value: ");
        System.out.println(stack.getMax());
        System.out.println("Min value: ");
        System.out.println(stack.getMin());
        System.out.print("Duplicates before: \n");
        System.out.println(stack.getDuplicate());
        stack.push(14);
        System.out.print("Duplicates after: \n");
        System.out.println(stack.getDuplicate());


        StackOfIntegers stack2 = new StackOfIntegers(50);
        for (int i = 30; i < 50; i++)
            stack2.push(i);

        System.out.print("======================\n");
        System.out.println("Stack 2 ");
        System.out.println("----------");
        System.out.println("Max value: ");
        System.out.println(stack2.getMax());
        System.out.println("Min value: ");
        System.out.println(stack2.getMin());
        System.out.print("Duplicates before: ");
        System.out.println(stack2.getDuplicate());
        stack2.push(30);
        System.out.print("Duplicates after: ");
        System.out.println(stack2.getDuplicate());
        stack.toCopy(stack2);

        System.out.println("Stack 2:");
        for (int i: stack2.elements){
            System.out.print(i+" ");
        }
        System.out.println("\n");
        System.out.println("Copy Stack 2 into Stack 1");
        System.out.println("New Size: "+ stack.getSize());
        for (int i: stack2.elements) {
            System.out.print(i+" ");
        }

        System.out.println("\n Emplty the stacks: \n");
        stack.toClear();
        stack2.toClear();

        System.out.println("Stack 1: \n");
        for (int i: stack.elements){
            System.out.print(i + " ");

        }

        System.out.println("\n Stack 2: \n");
        for (int i : stack2.elements) {
            System.out.print(i+" ");

        }

    }

}


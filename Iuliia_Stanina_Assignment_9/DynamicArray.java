public class DynamicArray {
    
    // int array with beginning size 1
    private int[] elements = new int[1];
    
    DynamicArray() {
        // default element is minimum int value
        this.elements[0] = Integer.MIN_VALUE;
    }  
    
    public void setElement(int index, int element) throws MinValueException, NegativeIndexException{

        // index >= 0
        if (index < 0) {
            throw new NegativeIndexException(index);
        }           
            
        // if element is integer minimun throw exception
        if (element == Integer.MIN_VALUE) {
            throw new MinValueException("MIN_INT Value is not allowed ", element);
        }
        
        try {
            // index out of bounds
            if (this.elements.length <= index) {
                throw new CustomOutOfBoundException(this.elements);
            } else {
                // assign element to corresponding index in array
                this.elements[index] = element;
            }

        } catch (CustomOutOfBoundException e) {
            // handle index out of bounds
            System.out.println("***\nError occured, error is : \n" + e + "\nindex does not exist. Creating index ...\n");
         
            // this will create array the length of provided index
            // the index provided out of bounds will be the last in array with its value
            int[] temp = new int [index+1];
            // add existing values to new array
            for (int i = 0; i < this.elements.length; i++){
                temp[i] = this.elements[i];
            }
            // add default values (except the last index)
            for (int i = this.elements.length; i < index; i++) {
                temp[i] = Integer.MIN_VALUE;
            }
            // assign element to a corresponding index
            temp[index] = element;
            this.elements = temp;
            System.out.println("Done\n***");
        }
    }

    public int getElement(int index) throws NegativeIndexException, MinValueException {
        int result;
        try {
            // in index is out of bounds
            if (this.elements.length <= index) {
                throw new CustomOutOfBoundException(this.elements);
            }
            // index >= 0
            if (index < 0) {
                throw new NegativeIndexException(index);
            }
            // if element is integer minimun throw exception
            if (this.elements[index] == Integer.MIN_VALUE) {
                throw new MinValueException("No element, try different index. Your index is ", index);
            }
            else {
                result = this.elements[index];
                System.out.println("Index " + index + " => value " + result);
            }    
        } catch (CustomOutOfBoundException e){
            // handle exception
            System.out.println("***\nError occured, error is : \n" + e + "\nTry different index\n***");
            result = Integer.MIN_VALUE;
        }

        return result;

    }

    public void removeElement(int index) throws NegativeIndexException, MinValueException {
        
        try {
            // in index is out of bounds
            if (this.elements.length <= index) {
                throw new CustomOutOfBoundException(this.elements);
            }
            // index >= 0
            if (index < 0) {
                throw new NegativeIndexException(index);
            }
            // if element is integer minimun throw exception
            if (this.elements[index] == Integer.MIN_VALUE) {
                throw new MinValueException("No element, try different index. Your index is ", index);
            }
            System.out.println("Index " + index + " => value " + this.elements[index] + " was removed");
            this.elements[index] = Integer.MIN_VALUE;
        
        } catch (CustomOutOfBoundException e) {
            // handle exception
            System.out.println("***\nError occured, error is : \n" + e + "\nTry different index\n***");
        }
 
    }

    public String printInfo() {
        String res = "";
        for (int i = 0; i< elements.length; i++) {
            if (elements[i] != Integer.MIN_VALUE) {
                res += "Index " + i + " => Value " + elements[i] + "\n";
            }
        }
        if (res.length() < 1) {
            return "No elements";
        } else {
            return res;
        }
    }
}

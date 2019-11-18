class Stack<E extends Object>{
    Object[] array;
    int top;

    public Stack(Integer size){
        array = new Object[size];
        top = 0;
    }

    public void add(E item){
        //null item not allowed
        if(item == null){
            throw new IllegalAccessError();
        }
        else{
            // stack is full
            if(top == array.length){
                throw new IndexOutOfBoundsException();
            }
            array[top] = item;
            top ++;
        }
    }

    public E pop(){
        // stack is empty
        E item;
        if(top == 0){
            throw new IllegalAccessError();
        }
        else{
            item = (E) array[top];
            top --;
        }
        return (E) item;
    }

    public void printAll(){
        String s = "[ ";
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                s += array[i].toString() + " ";
            }
            else{
                s += "null ";
            }
        }
        System.out.println(s += " ]");
    }

    public static void main(String args[]){
        Stack<Integer> s = new Stack(5);
        // s.add(1);
        // s.printAll();
        // s.add(2);
        // s.printAll();
        // s.add(3);
        // s.printAll();
        // s.add(4);
        // s.printAll();
        // s.add(5);
        // s.printAll();
        // s.add(1);
        // s.printAll();
        s.pop();
    }
}
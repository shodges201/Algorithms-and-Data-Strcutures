class Queue<E extends Object> {
    Object[] array;
    int head;
    int tail;

    public Queue(Integer length) {
        array = new Object[length];
        head = 1;
        tail = 1;
        System.out.println(array.length);
    }

    public void enqueue(E item) {
        if(head == tail + 1 || (head == 1  && tail == array.length)){
            System.out.print("head: " + ((Integer)(head)).toString());
            System.out.println("tail: " + ((Integer)(tail)).toString());
            throw new IllegalStateException();
        }
        array[tail - 1] = item;
        if (tail == array.length) {
            tail = 1;
        } else {
            tail++;
        }
    }

    public E dequeue() {
        E frontItem = (E) array[head - 1];
        array[head - 1] = null;
        if (head == array.length) {
            head = 1;
        } else {
            head++;
        }
        return frontItem;
    }

    public void printAll() {
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

    public static void main(String[] args) {
        Queue q = new Queue<Integer>(5);
        q.enqueue(1);
        q.printAll();
        q.enqueue(2);
        q.printAll();
        // q.dequeue();
        // q.printAll();
        q.enqueue(2);
        q.printAll();
        q.enqueue(3);
        q.printAll();
        q.enqueue(4);
        q.printAll();
        q.enqueue(5);
        q.printAll();
        q.enqueue(6);
        q.printAll();
    }
}
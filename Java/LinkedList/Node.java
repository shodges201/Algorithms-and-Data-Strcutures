class Node<E extends Object>{
    public E value;
    public Node next;
    public Node prev;

    public Node(E value){
        this.value = value;
        next = null;
        prev = null;
    }

    /*public static void main(String[] args){
        Node<Integer> n = new Node(4);
        System.out.println(n.key);
        System.out.println(n.next);
        System.out.println(n.prev);
    }*/
}
class LinkedList<E>{
    Node head;

    public LinkedList() {
        head = null;
    }

    public void add(Node n) {
        if (head == null) {
            head = n;
        } else {
            Node temp = head;
            head = n;
            n.next = temp;
        }
    }

    public Node search(E val) {
        Node currentNode = head;
        while (currentNode != null && currentNode.value != val) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    private Node findPreviousNode(E value) {
        Node currentNode = head;
        while (currentNode != null && currentNode.next.value != value) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    public void delete(Node n) {
        if (n == null) {
            throw new IllegalAccessError("Node Must Exist");
        } else {
            if (n.value == head.value) {
                head = n.next;
                n.next = null;
            } else {
                Node prevNode = findPreviousNode((E) n.value);
                prevNode.next = n.next;
            }
        }
    }

    public void delete(E value) {
        if (value == null) {
            throw new IllegalAccessError("Must Give Valid Value");
        } else {
            if (value == head.value) {
                Node temp = head;
                head = head.next;
                temp.next = null;
            } else {
                Node n = search(value);
                if (n.value != value || n == null) {
                    throw new IllegalAccessError("Item doesn't exist in the list");
                }
                delete(n);
            }
        }
    }

    public void printList() {
        Node currentNode = head;
        String s = "";
        while (currentNode != null) {
            s += currentNode.value.toString() + " -> ";
            currentNode = currentNode.next;
        }
        System.out.println(s);
    }

    public static void main(String[] args) {
        LinkedList<Integer> l = new LinkedList<>();
        Node<Integer> n = new Node(5);
        System.out.println(n.value);
        l.add(n);
        l.printList();
        l.add(new Node<Integer>(6));
        l.printList();
        l.add(new Node<Integer>(7));
        l.printList();
        l.delete(n);
        l.printList();
        l.delete(7);
        l.printList();
        l.delete(new Node(6));
        l.printList();
    }
}
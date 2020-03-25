import java.util.Queue;
import java.util.LinkedList;

class BSTNode<E extends Comparable<E>> {
    private E key;
    private BSTNode left;
    private BSTNode right;
    private BSTNode parent;

    BSTNode(E value, BSTNode sentinel) {
        key = value;
        left = sentinel;
        right = sentinel;
        parent = sentinel;
    }

    public BSTNode getLeft(){
        return this.left;
    }

    public BSTNode getRight(){
        return this.right;
    }

    public BSTNode getParent(){
        return this.parent;
    }

    public E getKey(){
        return this.key;
    }

    public void setLeft(BSTNode child){
        this.left = child;
    }

    public void setRight(BSTNode child){
        this.right = child;
    }

    public void setParent(BSTNode parent){
        this.parent = parent;
    }

    public boolean equals(BSTNode otherNode){
        return this.key == otherNode.key;
    }
}


class BinarySearchTree<E extends Comparable<E>> {

    BSTNode head;
    final BSTNode sentinel;

    BinarySearchTree() {
        sentinel = new BSTNode(null, null);
        head = sentinel;
    }

    public void insert(E newValue) {
        BSTNode newNode = new BSTNode(newValue, sentinel);

        if (head == sentinel) {
            head = newNode;
            head.setLeft(sentinel);
            head.setRight(sentinel);
        } else {
            BSTNode currentNode = head;
            while (true) {
                if (newNode.getKey().compareTo(currentNode.getKey()) > 0) {
                    if (currentNode.getRight() == sentinel) {
                        currentNode.setRight(newNode);
                        newNode.setParent(currentNode);
                        return;
                    }
                    currentNode = currentNode.getRight();
                } else {
                    if (currentNode.getLeft() == sentinel) {
                        currentNode.setLeft(newNode);
                        newNode.setParent(currentNode);
                        return;
                    }
                    currentNode = currentNode.getLeft();
                }
            }
        }
    }

    public void printTree() {
        Queue<BSTNode> q = new LinkedList();
        BSTNode currentNode = head;
        BSTNode dummyNode = new BSTNode(null, sentinel);
        q.add(currentNode);
        while (!q.isEmpty()) {
            currentNode = q.remove();
            System.out.println(currentNode.getKey());
            if (currentNode != dummyNode) {
                if (currentNode.getLeft() != sentinel) {
                    q.add(currentNode.getLeft());
                } else {
                    q.add(dummyNode);
                }
                if (currentNode.getRight() != sentinel) {
                    q.add(currentNode.getRight());
                } else {
                    q.add(dummyNode);
                }
            }
        }
    }

    public static void main(String args[]) {
        BinarySearchTree<Integer> bst = new BinarySearchTree();
        bst.insert(4);
        bst.insert(5);
        bst.insert(3);
        bst.insert(6);
        bst.insert(2);
        bst.insert(1);
        bst.printTree();
    }
}
abstract class ArrayList<E>{
    protected int capacity;
    protected int size;
    public ArrayList(){
        capacity = 10;
        size = 0;
    }
    public ArrayList(int capacity){
        this.capacity = capacity;
    }
    public abstract void add(E item);
    public abstract void add(Integer index, E item);
    public abstract E get(Integer index);
    public abstract void set(Integer index, E item);
    public abstract boolean contains(E item);
    public abstract Integer indexOf(E item);
    public abstract Integer lastIndexOf(E item);
    public abstract E remove(Integer index);
    public abstract boolean remove(E o);
    public abstract void clear();
    public abstract boolean isEmpty();
    public abstract Integer size();

}
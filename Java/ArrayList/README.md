# LinkedList

A simple recreation of Java's built in ArrayList, a resizable list used for storing an unknown number of items in an array-like format. 

## Methods
 
* `public void add(E item)`:
Adds an item of type E to the end of the list.

* `public void add(Integer index, E item)`:
Adds an item of type E into index `index`, and pushes the items after it over by a space.

* `public E get(Integer index)`: 
Returns the value of an item at index `index`.

* `public void set(Integer index, E item)`:
Replaces the item at index `index` with an item of type E. Doesn't allow for an item to be added at any index such that index ≥ ArraList.size() or index ≤ 0.

* `public Boolean contains(E item)`:
Returns `True` if an item in the ArrayList has the same value as `item`, otherwise `False` is returned.

* `public Integer indexOf(E item)`:
Returns the Integer index of the item of value `item` and type `E`. If `item` is not in the array then -1 is returned.






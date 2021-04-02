# data-structure

Data structure is **data storage format**. It is the collection of values, and the format they are stored in.  
The relationships between the values in the collection, as well as the operations applied on the data stored in the structure.

## array

Array is a data structure, that stores a collection of values, where each value is referenced using an index (or a key).  
In Java, array is a **homogeneous** containers. It means, they only can contain values of the same type. The fundamental concept of the
array is the _INDEX_. This index value is used for each operation on the array; from accessing values to inserting, updating and deleting.

It is best to use an ArrayList when:

1. You want to access random items frequently.
2. You only need to add or remove elements at the end of the list.

## linked_list

Linked list is a linear data structure, where each element in the list, is contained in a separate object called a **node**. A node models
two pieces of information:

1. An individual item of the data we want to store.
2. A reference to the next node in the list.

The first node in the list is called **HEAD** of the list. The list only maintains the reference to the head.   
The last node is called **TAIL**. The tail denotes end of the list. Each node in the list is pointing to the next node, but tail doesn't
point to anything.

Nodes are, what we called, self-referential objects. The definition of the node includes a link to another node. To add an element to the
list, the element is placed into a new node and that node is linked to one of the previous node in the list.

It is best to use a LinkedList when:

1. You only use the list by looping through it instead of accessing random items.
2. You frequently need to add and remove items from the beginning, middle or end of the list.

# algorithm

A set of steps or instructions for completing a task.  
Algorithm efficiency have two aspects:

1. Time complexity - how long it takes to complete a task (running time of an algorithm).
2. Space complexity - amount of memory take from the computer, while working on a task.

## search strategies

### linear search

Linear search ran on the array and sequentially check each value, till target value is found.

1. Best case: target value is a first element in the list (index 0).
2. Worst case: target value is a last element in the list or is out of the list (not exist).

### binary search

Binary search, also known as **half-interval search**. Binary search compares the target value to the middle element of the array.  
Pre-conditions:

1. The list must be sorted.
2. The steps need to be distinct.
3. The algorithm should produce a result.
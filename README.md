# Sort Manager


___

### What is SortManager?

Sort Manager is a program will allow you the user to choose a sorting algorithm and sort a randomised array. Current the program is developed with the following algorithms.

- Bubble Sort
- Merge Sort
- Binary Sort
- Quick Sort
- Insertion Sort

The program can be extended by using the interface ``Sorter``. Which I will showcase below.

___

### MVC pattern

Application is developed using the MVC to separate business logic from display logic. 

##### Views

``ConsoleView`` : Displays user interface and processes Input from user.

``SortView`` : Displays sort report after sorting functions have finished.

##### Models

``Sorter`` : This interfaces serves a common function between all sort algorithms allowing for expansion of the sorters.

``BubbleSort``
``MergeSort``
``BinarySort``
``QuickSort``
``InsertionSort``

##### Controllers

``SortManager`` : Controls the main loop of the program and is initialised from here.

``SortController`` : Controls the view and model for sorting of algorithms. Handles all functions to sort using user's inputs.

``Timer`` : Performance Timer using nanoseconds.

``Sorters`` : Enumeration Factory for Sorting Algorithms.

``RandomArray`` : Generates a random array with no duplicates.

### Sorter Interface

Using this interface you can provide the Sort Controller with an algorithm to use.

```java
public interface Sorter {
    int[] sortArray(int[] arrayToSort);
}
```


##### Adding a new algorithm.

First we add the new class to the project implementing the interface.

```java
public class ExampleSort implements Sorter {
    @Override
    public int[] sortArray(int[] arrayToSort) {}
}
```

Then you add the new sorting algorithm to the enum factory and all code that is used after will adjust accordingly.

```java
public enum Sorters {
    // ...
    EXAMPLE_SORT("Example Sort") {
        @Override
        public Sorter getSorter(){
            return new ExampleSort();
        }
    },
    
    // ...
}
```
___

### Known Bugs

- Algorithm Sorter accepts inputs with leading zeros such as ``004`` and processes then as ``4``.
- QuickSort needs more memory allocated to the JVM because there is a StackOverflowException from the recusive function.
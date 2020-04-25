package com.practice.ds.heap;

public abstract class Heap {

    int[] arr = new int[100];
    int size = 0;

    public boolean hasLeftChild(int i){
        return 2*i + 1 < size;
    }

    public boolean hasRightChild(int i){
        return  2*i + 2 < size;
    }

    public boolean hasParent(int i){
        return i != 0;
    }

    public int leftChildIndex(int i) {
        if(hasLeftChild(i))
            return 2*i + 1;
        return -1;
    }

    public int rightChildIndex(int i) {
        if(hasRightChild(i))
            return 2*i +2;
        return -1;
    }

    public int parentIndex(int i) {
        return (i-1)/2;
    }

    public int getParent(int i) {
        return arr[parentIndex(i)];
    }

    public int getLeftChild(int i) {
        return arr[leftChildIndex(i)];
    }

    public int getRightChild(int i) {
        return arr[rightChildIndex(i)];
    }

    public Integer getTop() {
        if(size==0)
            throw new IllegalStateException("No elements in heap");
        return arr[0];
    }

    public void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void print() {
        for (int i = 0; i < size / 2; i++) {
            System.out.print(" PARENT : " + arr[i]
                              + " LEFT CHILD : " + arr[2 * i + 1]
                              + " RIGHT CHILD :" + arr[2 * i + 2]);
            System.out.println();
        }
    }

    public void insert(int e) {
        arr[size] = e;
        size++;
        heapifyUp();
    }

    public int removeTop() {
      if(size==0)
          throw new IllegalStateException("No elements in heap");
      int item = arr[0];
      arr[0] = arr[size-1];
      size--;
      heapifyDown();
      return item;
    }


    public abstract void heapifyUp();
    public abstract void heapifyDown();
}

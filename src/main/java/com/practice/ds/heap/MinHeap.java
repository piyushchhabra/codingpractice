package com.practice.ds.heap;

public class MinHeap extends Heap{

    @Override
    public void heapifyUp() {
        int current = size - 1;
        while(hasParent(current) && getParent(current) > arr[current]) {
            swap(current, parentIndex(current));
            current = parentIndex(current);
        }
    }

    @Override
    public void heapifyDown() {
        int current = 0;
        while(hasLeftChild(current)) {
            int smallerIndex = leftChildIndex(current);
            if(hasRightChild(current) && getRightChild(current) < getLeftChild(current)) {
                smallerIndex = rightChildIndex(current);
            }
            if(arr[current] < arr[smallerIndex])
                break;
            else{
                swap(current, smallerIndex);
            }
            current = smallerIndex;
        }
    }
}

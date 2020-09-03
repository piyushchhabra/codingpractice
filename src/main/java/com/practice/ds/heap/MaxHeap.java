package com.practice.ds.heap;

public class MaxHeap extends Heap {

    @Override
    public void heapifyUp() {
        int current = size;
        while (arr[current] > arr[getParent(current)]) {
            swap(current, getParent(current));
            current = getParent(current);
        }
    }

    @Override
    public void heapifyDown() {

    }
}

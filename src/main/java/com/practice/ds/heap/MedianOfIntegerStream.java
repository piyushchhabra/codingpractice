package com.practice.ds.heap;

public class MedianOfIntegerStream {

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        minHeap.insert(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        minHeap.print();

        System.out.println("---------------");
        minHeap.removeTop();
        minHeap.print();
    }
}

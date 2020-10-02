package tree;

import model.HeapNode;

public class Heap {

    private static int DEFAULT_MAX_SIZE = 20;

    private int currentSize;
    private int maxSize;
    private HeapNode[] array;

    public Heap() {
        this.currentSize = 0;
        this.maxSize = DEFAULT_MAX_SIZE;
        this.array = new HeapNode[DEFAULT_MAX_SIZE];
    }

    public boolean insert(int value){
        if(currentSize >= maxSize){
            return false;
        }

        HeapNode newNode = new HeapNode(value);
        array[currentSize++] = newNode;
        trickleUp(currentSize);
        return true;
    }

    private void trickleUp(int index) {
        HeapNode bottom = array[index];
        int parent = (index-1)/2;
        while(index > 0 && bottom.val > array[parent].val){
            array[index] = array[parent];
            index = parent;
            parent = (parent-1)/2;
        }
        array[index] = bottom;
    }

    public HeapNode remove(){
        if (currentSize == 0){
            return null;
        }

        HeapNode root = array[0];
        array[0] = array[--currentSize];
        trickleDown(0);
        return root;
    }

    private void trickleDown(int index) {
        HeapNode top = array[index];
        int largeChild;
        while (index < currentSize/2){
            int left = index*2+1;
            int right = left+1;
            if(right < currentSize && array[right].val > array[left].val){
                largeChild = right;
            }else {
                largeChild = left;
            }

            if(array[largeChild].val <= top.val)
                break;

            array[index] = array[largeChild];
            index = largeChild;
        }
        array[index] = top;
    }

    public boolean changeLevel(int key,int value){
        if(key < 0 || key > currentSize){
            return false;
        }

        int oldVal = array[key].val;
        array[key].val = value;
        if(oldVal > value){
            trickleUp(value);
        }else {
            trickleDown(value);
        }

        return true;
    }
}

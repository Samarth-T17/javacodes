package BINARYTREE;

public class SegmentTree {
    private class Node{
        int data;
        int leftIndex;
        int rightIndex;
        Node Left;
        Node Right;
        Node(int data, int leftIndex, int rightIndex){
            this.data = data;
            this.leftIndex = leftIndex;
            this.rightIndex = rightIndex;
        }
    }
    Node root;
    public void populate(int[] num){

    }
}

package datastructures.balancedtrees;

public class AVLNode {

    private int data;
    private int height;
    private AVLNode leftAVLNode;
    private AVLNode rightAVLNode;

    public AVLNode() {
    }

    public AVLNode(int data) {
        this.data = data;
        this.height = 1;
    }
    
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public AVLNode getLeftAVLNode() {
        return leftAVLNode;
    }

    public void setLeftAVLNode(AVLNode leftAVLNode) {
        this.leftAVLNode = leftAVLNode;
    }

    public AVLNode getRightAVLNode() {
        return rightAVLNode;
    }

    public void setRightAVLNode(AVLNode rightAVLNode) {
        this.rightAVLNode = rightAVLNode;
    }
}
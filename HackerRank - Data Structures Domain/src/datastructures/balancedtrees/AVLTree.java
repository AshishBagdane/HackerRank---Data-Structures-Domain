package datastructures.balancedtrees;

public class AVLTree {
    
    private AVLNode root;

    public AVLTree() {
        this.root = null;
    }
    
    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.getLeftAVLNode();
        AVLNode T2 = x.getRightAVLNode();
        
        x.setRightAVLNode(y);
        y.setLeftAVLNode(T2);
        
        x.setHeight(Math.max(getHeight(x.getLeftAVLNode()), getHeight(x.getRightAVLNode())) + 1);
        y.setHeight(Math.max(getHeight(y.getLeftAVLNode()), getHeight(y.getRightAVLNode())) + 1);
        
        return x;
    }
    
    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.getRightAVLNode();
        AVLNode T2 = y.getLeftAVLNode();
        
        y.setLeftAVLNode(x);
        x.setRightAVLNode(T2);
        
        x.setHeight(Math.max(getHeight(x.getLeftAVLNode()), getHeight(x.getRightAVLNode())) + 1);
        y.setHeight(Math.max(getHeight(y.getLeftAVLNode()), getHeight(y.getRightAVLNode())) + 1);
        
        return y;
    }
    
    int getBalance(AVLNode node) {
        if(node==null) {
            return 0;
        }
        return getHeight(node.getLeftAVLNode()) - getHeight(node.getRightAVLNode());
    }
    
    int getHeight(AVLNode node) {
        if(node==null) {
            return -1;
        }
        return node.getHeight();
    }
    
    AVLNode insert(AVLNode node, int data) {
        if(node==null) {
            return new AVLNode(data);
        }
        if(data<node.getData()) {
            node.setLeftAVLNode(insert(node.getLeftAVLNode(), data));
        }else{
            node.setRightAVLNode(insert(node.getRightAVLNode(), data));
        }
        
        node.setHeight(Math.max(getHeight(node.getLeftAVLNode()), getHeight(node.getRightAVLNode())) + 1);
        int balanceDifference = getBalance(node);
        
        if(balanceDifference>1 && data<node.getLeftAVLNode().getData()) {
            return rightRotate(node);
        }
        if(balanceDifference<-1 && data>node.getRightAVLNode().getData()) {
            return leftRotate(node);
        }
        if(balanceDifference>1 && data<node.getLeftAVLNode().getData()) {
            node.setLeftAVLNode(leftRotate(node.getLeftAVLNode()));
            return rightRotate(node);
        }
        if(balanceDifference<-1 && data>node.getRightAVLNode().getData()) {
            node.setRightAVLNode(rightRotate(node.getRightAVLNode()));
            return leftRotate(node);
        }
        return node;
    }
    
    void preOrder(AVLNode node) {
        if(node!=null) {
            System.out.print(node.getData() + " ");
            preOrder(node.getLeftAVLNode());
            preOrder(node.getRightAVLNode());
        }
    }

    public AVLNode getRoot() {
        return root;
    }

    public void setRoot(AVLNode root) {
        this.root = root;
    }
}

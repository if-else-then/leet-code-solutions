/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        bfsAndConnect (root, null);
        return root;
    }
    private void bfsAndConnect(Node n, Node m) {
        if (n == null) return ;
        setNext(n,m);
        bfsAndConnect(getLeft(n), getRight(n));
        bfsAndConnect(getRight(n), getLeft(m));
    }
    
    private void setNext(Node n, Node m) {
        if (n == null) return;
        n.next = m;
    }
    private Node getLeft (Node n) {
        if (n == null) return null;
        return n.left;
    }
    private Node getRight(Node n) {
        if (n == null) return null;
        return n.right;
    }
}

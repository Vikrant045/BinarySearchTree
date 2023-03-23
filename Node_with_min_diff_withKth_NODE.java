public class Node_with_min_diff_withKth_NODE {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    public static Node minDiff(Node root, int k){
        if(root == null){
            return null;
        }

         root.left = minDiff(root.left, k);
         root.right = minDiff(root.right, k);

         
    }
    public static void main(String args[]){
        Node root = new Node(8);// bst1
        root.left = new Node(5);
        root.right = new Node(11);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(20);
int k =5;
       System.out.println(minDiff( root,  k)); 
    }
    
}

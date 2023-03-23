public class Sum_eles_lies_INRange {
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
static int sum=0;
   public static int  sumofRange(Node root , int L , int R){

    if(root == null){
        return 0;
    }

    int left = sumofRange(root.left, L, R);
    int right = sumofRange(root.right, L, R);
    
    if(root.data>=L && root.data<=R){
        sum+= root.data;
    }
    return sum;
    

    }
    public static void main(String args[]){
        Node root = new Node(8);// bst1
        root.left = new Node(5);
        root.right = new Node(11);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(20);
System.out.println(sumofRange(root, 3, 6));

    }
    
}

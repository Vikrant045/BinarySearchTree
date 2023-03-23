public class ValidateBST {
    static class Node {
        int data;
        Node left;
        Node right;
        public Object ri;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node root,int val){

        if(root==null){
            root = new Node(val);
            return root;
        }
        if(root.data>val){
            root.left =insert(root.left, val);
        }
        if(root.data<val){
            root.right = insert(root.right, val);
        }
        return root;
    }
    public static void inOrder(Node root){
        if(root == null){
            return;
        }
         inOrder(root.left);
         System.out.print(root.data+" ");
         inOrder(root.right);
    }

    public static boolean validate(Node root,Node min , Node max){
        if(root== null){
            return true;
        }
        if(min != null && root.data<=min.data){
            return false;
        }
        else if(max!= null && root.data>= max.data){
return false;
        }
       
     return  validate(root.left, min, root) && validate(root.right, root, max);
    }
    public static void main(String args[]){
        int values [] ={11,11,11};

        Node root = null;
        for(int i=0;i<values.length;i++){
            root = insert(root, values[i]);
        }
        inOrder(root);
        System.out.println(validate(root, null, null));
    }
    
}

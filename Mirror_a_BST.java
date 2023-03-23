public class Mirror_a_BST {
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
    static class Node {
        int data;
        Node left;
        Node right;
        public Object ri;

        public Node(int data) {
            this.data = data;
        }
    }
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");

         preOrder(root.left);
         preOrder(root.right);
    }

    public static Node mirror(Node root){
        if(root == null){
            return null;
        }
        Node left = mirror(root.left);
        Node right = mirror(root.right);

        root.left = right;
        root.right = left;
        return root;
    }
    public static void main(String args[]){
        int values [] ={8,5,6,3,10,11};

        Node root = null;
        for(int i=0;i<values.length;i++){
            root = insert(root, values[i]);
        }
        preOrder(root);
       root = mirror(root);
        System.out.println();
        preOrder(root);

}
}

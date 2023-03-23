public class DeleteANode {
    static class Node {
        int data;
        Node left;
        Node right;
        public Object ri;

        public Node(int data) {
            this.data = data;
        }
    }
    private static Object ht;
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

    public static Node deleteNode(Node root, int val){
        if(root.data>val){
            root.left = deleteNode(root.left, val);
        }
        else if(root.data<val){
            root.right = deleteNode(root.right, val);
        }
        else{

            if(root.left== null && root.right== null){// Case 1 leaf node
                return null;
            }
            if(root.left==null){ // case 2 one child
                return root.right;
                    }
                    else  if(root.right==null){ // case 2 one child
                        return root.left;
                    }

            // case 3

           Node inSucc = inOrderSuccessor(root.right);
           root.data = inSucc.data;
           root.right = deleteNode(root.right, inSucc.data);
         
        }
        return root;
    }
    public static Node inOrderSuccessor(Node root){
        while(root.left!= null){
            root = root.left;
        }
        return root;
    }
    public static void inOrder(Node root){
        if(root == null){
            return ;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static void main(String args[]){
        int values [] ={8,5,3,1,4,6,10,11,14};

        Node root = null;
        for(int i=0;i<values.length;i++){
            root = insert(root, values[i]);
        }
        
        inOrder( root);
        deleteNode(root, 1);
        System.out.println();
        inOrder( root);

    }
    
}

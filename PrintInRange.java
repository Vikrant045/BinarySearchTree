public class PrintInRange {

    static class Node{
        int data ;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }
    public static Node insert(Node root,int val ){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data>val){
            root.left = insert(root.left, val);
        }
        if(root.data<val){
            root.right = insert(root.right,val);
        }
        return root;
    }
    public static void in_range(Node root,int k1, int k2){
        if(root == null){
            return;
        }
        if(root.data>=k1 && root.data<=k2){
            in_range(root.left, k1, k2);
            System.out.print(root.data+" ");
            in_range(root.right, k1, k2);
        }
        else if(root.data>k1 && root.data> k2){
            in_range(root.left, k1, k2);
        }
        else{
            in_range(root.right, k1, k2);
        }
    }
    public static void inOrder(Node root){
        if(root == null){
            return;
        }
         inOrder(root.left);
         System.out.print(root.data+" ");
         inOrder(root.right);
    }

    public static void main(String args[]){
       int arr[] ={45,1,26,21,16,100,300,14,9};
       Node root = null;

       for(int i=0 ; i<arr.length;i++){
        root = insert(root, arr[i]);
       }
       inOrder(root);
       System.out.println();
       in_range(root, 10, 100);
    }
    
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * Definition for a binary tree node.
 */
class TreeNode {

    // **** class members ****
    public int val;
    public TreeNode left;
    public TreeNode right;

    // **** constructor(s) ****
    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // **** ****
    @Override
    public String toString() {
        return "" + this.val;
    }
}


/**
 * 
 */
public class ConstructBSTFromPreorderTraversal {


    /**
     * Recursive call
     * Runtime: O(n)
     */
    static TreeNode populate(int[] arr, int[] idx, int constraint) {

        // **** visit node ****
        TreeNode node = new TreeNode(arr[idx[0]++]);

        // **** visit left sub tree ****
        if (idx[0] < arr.length && arr[idx[0]] < node.val) {
            node.left = populate(arr, idx, node.val);
        }

        // **** visit right sub tree ****
        if (idx[0] < arr.length && arr[idx[0]] < constraint) {
            node.right = populate(arr, idx, constraint);
        }

        // **** return BST ****
        return node;
    }


    /**
     * Return the root node of a BST that matches the given preorder traversal.
     * According to the problem constraints, there are no empty trees.
     * 
     * Runtime: 0 ms, faster than 100.00% of Java online submissions.
     * Memory Usage: 37 MB, less than 39.24% of Java online submissions.
     */
    static TreeNode bstFromPreorder(int[] preorder) {
        
        // **** populate and return BST (entry for recursive call) ****
        return populate(preorder, new int[] {0}, Integer.MAX_VALUE);
    }
 

    /**
     * BST in order traversal.
     * Recursive call.
     * 
     * !!! This method is not part of the solution !!!
     */
    static void inOrder(TreeNode root) {

        // **** end condition ****
        if (root == null)
            return;

        // **** visit left sub tree ****
        inOrder(root.left);

        // **** visit root ****
        System.out.print(root.val + " ");

        // **** visit right sub tree ****
        inOrder(root.right);
    }


    /**
     * Test scaffolding.
     * 
     * !!! This method is not part of the solution !!!
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        // **** open buffered reader ****
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        // **** ****
        String[] strs = reader.readLine().split(",");

        // **** close buffered reader ****
        reader.close();

        // **** allocate and populate array ****
        int[] preorder = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            preorder[i] = Integer.parseInt(strs[i]);
        }

        // ???? ????
        System.out.println("main <<< preorder: " + Arrays.toString(preorder));
        
        // **** generate the BST from the specified array ****
        TreeNode root = bstFromPreorder(preorder);

        // ???? ????
        System.out.print("main <<<  inOrder: ");
        inOrder(root);
    }
}
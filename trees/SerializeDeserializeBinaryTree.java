package trees;


/*

            1
          /   \
         2     3
       /   \     \
      4     5     6
           /
          7
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SerializeDeserializeBinaryTree
{

    public static String serialize(TreeNode root)
    {
        if(root==null){
            return "";
        }

        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode t = queue.poll();
            if(t!=null){
                sb.append(t.val + ",");
                queue.add(t.left);
                queue.add(t.right);
            }else{
                sb.append("#,");
            }
        }

        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }


    public static String serializeOptimized(TreeNode root)
    {
        if(root==null)
            return null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            TreeNode h = stack.pop();
            if(h!=null){
                sb.append(h.val+",");
                if (h.right != null || h.left != null) {
                    sb.append("',");
                }
                if (h.right == null && h.left == null) {
                    continue;
                }
                stack.push(h.right);
                stack.push(h.left);
            } else{
                sb.append("/,");
            }
        }

        return sb.toString().substring(0, sb.length()-1);
    }




    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null || data.length()==0)
            return null;

        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));


        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i=1;
        while(!queue.isEmpty()){
            TreeNode t = queue.poll();

            if(t==null)
                continue;

            if(!arr[i].equals("#")){
                t.left = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(t.left);

            }else{
                t.left = null;
                queue.offer(null);
            }
            i++;

            if(!arr[i].equals("#")){
                t.right = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(t.right);

            }else{
                t.right = null;
                queue.offer(null);
            }
            i++;
        }
        return root;
    }


    public static void main(String[] args)
    {
        final TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.right = new TreeNode(6);
        tree.left.right.left = new TreeNode(7);
        System.out.println(serialize(tree));
        System.out.println(serializeOptimized(tree));

    }
}


// 1'B'

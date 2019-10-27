package intervals;

import java.util.Scanner;
import java.util.Stack;

import tree.TreeNode;

public class IntervalTree implements Intervals {

  private TreeNode<String> root;

  private IntervalTree() {
    // No default constructor
  }

  public IntervalTree(String input) throws IllegalArgumentException {
    try {
      if (input.equals("")) {
        throw new IllegalArgumentException("Invalid input");
      }
      Scanner s = new Scanner(input.trim());
      Stack<TreeNode<String>> nodeStack = new Stack<>();
      s.useDelimiter(" ");

      while (s.hasNext()) {
        String node = s.next();
        if (!node.equals("")) {
          if (node.equals("U") || node.equals("I")) {
            TreeNode<String> optNode = new GroupNode<>(node);
            TreeNode<String> last = nodeStack.pop();
            TreeNode<String> secLast = nodeStack.pop();
            optNode.addChild(last);
            optNode.addChild(secLast);
            nodeStack.push(optNode);
            root = optNode;
          } else {
            if (node.matches("-?\\d*.-?\\d*")) {
              TreeNode<String> numberNode = new LeafNode<>(node);
              nodeStack.push(numberNode);
            } else {
              throw new IllegalArgumentException("Invalid input");
            }
          }
        }
      }
      if (root == null) {
        throw new IllegalArgumentException("Invalid input");
      }
    } catch (Exception e) {
      throw new IllegalArgumentException("Invalid input");
    }
  }

  @Override
  public Interval evaluate() {
    return root.evaluateInterval();
  }

  @Override
  public String textTree() {
    return root.textTree(0, false);
  }
}

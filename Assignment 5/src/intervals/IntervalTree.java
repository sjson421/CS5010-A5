package intervals;

import java.util.Scanner;
import java.util.Stack;

public class IntervalTree implements Intervals {

  private TreeNode<String> root;

  private IntervalTree() {
  }

  public IntervalTree(String input) throws IllegalArgumentException {
    try {
      Scanner s = new Scanner(input.trim());
      Stack<TreeNode<String>> nodeStack = new Stack<>();
      s.useDelimiter(" ");

      while (s.hasNext()) {
        String node = s.next();
        if (node.equals("U") || node.equals("I")) {
          TreeNode<String> optNode = new GroupNode<>(node);
          TreeNode<String> last = nodeStack.pop();
          TreeNode<String> secLast = nodeStack.pop();
          optNode.addChild(last);
          optNode.addChild(secLast);
          nodeStack.push(optNode);
          root = optNode;
        } else {
          TreeNode<String> numberNode = new LeafNode<>(node);
          nodeStack.push(numberNode);
        }
      }
    } catch (Exception e) {
      throw new IllegalArgumentException("Invalid input");
    }
  }

  @Override
  public Interval evaluate() {
    return null;
  }

  @Override
  public String textTree() {
    return null;
  }
}

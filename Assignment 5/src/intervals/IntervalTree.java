package intervals;

import java.util.Scanner;
import java.util.Stack;

public class IntervalTree implements Intervals {

  private intervals.TreeNode<String> root;

  private IntervalTree() {
  }

  public IntervalTree(String input) throws IllegalArgumentException {
    try {
      Scanner s = new Scanner(input.trim());
      Stack<intervals.TreeNode<String>> nodeStack = new Stack<>();
      s.useDelimiter(" ");

      while (s.hasNext()) {
        String node = s.next().trim();
        if (node.equals("U") || node.equals("I")) {
          intervals.TreeNode<String> optNode = new GroupNode<>(node);
          intervals.TreeNode<String> last = nodeStack.pop();
          intervals.TreeNode<String> secLast = nodeStack.pop();
          optNode.addChild(last);
          optNode.addChild(secLast);
          nodeStack.push(optNode);
          root = optNode;
        } else {
          if (node.matches("\\d*.\\d*")) {
            TreeNode<String> numberNode = new LeafNode<>(node);
            nodeStack.push(numberNode);
          } else {
            throw new IllegalArgumentException("Invalid input");
          }
        }
      }
    } catch (Exception e) {
      throw new IllegalArgumentException("Invalid input");
    }
  }

  @Override
  public Interval evaluate() {
    return root.evaluate();
  }

  @Override
  public String textTree() {
    return root.toString();
  }
}

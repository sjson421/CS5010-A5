package intervals;

import java.util.Scanner;
import java.util.Stack;

import tree.TreeNode;

/**
 * The tree for holding onto interval operations, with the input as intervals first, then
 * operations.
 */
public class IntervalTree implements Intervals {

  private TreeNode<String> root;

  private IntervalTree() {
    // No default constructor
  }

  /**
   * Allows for creation of an interval tree.
   *
   * @param input String input of an interval expression, written in postfix.
   * @throws IllegalArgumentException Thrown in case of invalid input.
   */
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
            if (node.matches("-?[\\d]+.-?[\\d]+")) {
              TreeNode<String> numberNode = new LeafNode<>(node);
              nodeStack.push(numberNode);
              root = numberNode;
            } else {
              throw new IllegalArgumentException("Invalid input");
            }
          }
        }
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

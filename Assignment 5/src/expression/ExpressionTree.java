package expression;

import java.util.Scanner;
import java.util.Stack;

import tree.TreeNode;

/**
 * The tree for holding onto algebraic expressions, with the input as postfix.
 */
public class ExpressionTree implements Expression {
  private TreeNode<String> root;

  private ExpressionTree() {
    // No default constructor
  }

  /**
   * Allows for creation of an expression tree with a postfix input of an algebraic expression.
   *
   * @param input String input of an expression.
   * @throws IllegalArgumentException Thrown in case of invalid input.
   */
  public ExpressionTree(String input) throws IllegalArgumentException {
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
          if (node.equals("+") || node.equals("-") || node.equals("*") || node.equals("/")) {
            TreeNode<String> optNode = new GroupNode<>(node);
            TreeNode<String> last = nodeStack.pop();
            TreeNode<String> secLast = nodeStack.pop();
            optNode.addChild(last);
            optNode.addChild(secLast);
            nodeStack.push(optNode);
            root = optNode;
          } else {
            if (node.matches("-?[\\d]+\\.?[\\d]*")) {
              TreeNode<String> numberNode = new LeafNode<>(node);
              nodeStack.push(numberNode);
              root = numberNode;
            } else {
              throw new IllegalArgumentException("Invalid input");
            }
          }
        }
      }
      if (nodeStack.size() != 1) {
        throw new IllegalArgumentException("Invalid input");
      }
    } catch (Exception e) {
      throw new IllegalArgumentException("Invalid input");
    }
  }

  @Override
  public double evaluate() {
    return root.evaluateDouble();
  }

  @Override
  public String infix() {
    return root.infix();
  }

  @Override
  public String schemeExpression() {
    return root.scheme();
  }

  @Override
  public String textTree() {
    return root.textTree(0, false, Integer.MAX_VALUE);
  }
}

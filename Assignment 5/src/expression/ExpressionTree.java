package expression;

import java.util.Scanner;
import java.util.Stack;

public class ExpressionTree implements Expression {
  private TreeNode<String> root;

  private ExpressionTree() {
  }

  public ExpressionTree(String input) throws IllegalArgumentException {
    Scanner s = new Scanner(input.trim());
    Stack<TreeNode<String>> nodeStack = new Stack<>();
    s.useDelimiter(" ");

    while (s.hasNext()) {
      String node = s.next();
      if (node.equals("+") || node.equals("-") || node.equals("*") || node.equals("/")) {
        TreeNode<String> optNode = new GroupNode<>(node);
        TreeNode<String> last = nodeStack.pop();
        TreeNode<String> secLast = nodeStack.pop();
        optNode.addChild(last);
        optNode.addChild(secLast);
        root = optNode;
      } else {
        TreeNode<String> numberNode = new LeafNode<>(node);
        nodeStack.push(numberNode);
      }
    }
  }

  @Override
  public double evaluate() {
    return 0;
  }

  @Override
  public String infix() {
    return null;
  }

  @Override
  public String schemeExpression() {
    return null;
  }

  @Override
  public String textTree() {
    return null;
  }
}

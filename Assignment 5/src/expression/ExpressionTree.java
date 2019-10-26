package expression;

import java.util.Scanner;

public class ExpressionTree implements Expression {
  private TreeNode<String> root;
  private ExpressionTree() {}
  public ExpressionTree(String input) throws IllegalArgumentException {
    Scanner s = new Scanner(input.trim());
    s.useDelimiter(" ");
    while(s.hasNext()) {
      String node = s.next();
      if (node.equals("+")||node.equals("-")||node.equals("*")||node.equals("/")) {

      } else {
        TreeNode<String> numberNode = new LeafNode<>();
      }
    }
    root = something;
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

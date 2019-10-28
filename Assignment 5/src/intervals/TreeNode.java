package intervals;

import java.util.List;

public interface TreeNode<T> {
  /**
   * Adds a new child under the current node.
   * @param child The node to add as a child of this node.
   * @return The current node, with its associated child nodes.
   */
  TreeNode<T> addChild(TreeNode<T> child);

  /**
   * Returns the data stored in the node.
   * @return Data of the node.
   */
  T getData();

  /**
   * Returns the string form of the current node, added to the tree.
   * @return The current node data, added to the tree.
   */
  String toString();

  /**
   * Gets the evaluated interval after specified union and intersection operations.
   * @return The evaluated interval after the operations provided
   */
  Interval evaluate();
}

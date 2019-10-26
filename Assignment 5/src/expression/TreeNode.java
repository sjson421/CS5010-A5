package expression;

import java.util.List;
import java.util.function.Predicate;

public interface TreeNode<T> {
  /**
   * Adds a new child under the current node.
   * @param identifier Predicate for identifying the node.
   * @param child The node to add as a child of this node.
   * @return The current node, with its associated child nodes.
   */
  TreeNode<T> addChild(Predicate<T> identifier, TreeNode<T> child);

  /**
   * Returns the entire tree as a list, depth first.
   * @return List of the tree, depth first.
   */
  List<T> toList();
}

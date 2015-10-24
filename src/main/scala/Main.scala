import model.{Node, Tree}

/**
 * ScalaBTree / Ed 
 * 24/10/2015 16:23
 */
object Main {

  def main(args: Array[String]) {
    val tree = Tree(Some(Node("a", None, None)))
    tree.insert("b")
    tree.insert("c")
    tree.inOrder()
  }

}

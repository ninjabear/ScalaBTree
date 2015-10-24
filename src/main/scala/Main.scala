import model.Tree

/**
 * ScalaBTree / Ed 
 * 24/10/2015 16:23
 */
object Main {

  def main(args: Array[String]) {
    val tree = Tree(1)
    tree.add(2)
    tree.add(3)
    tree.add(99)
    tree.add(31)
    tree.inOrder.foreach( x => println(x) )
  }

}

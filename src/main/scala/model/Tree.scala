package model

/**
 * ScalaBTree / Ed 
 * 24/10/2015 16:26
 */
case class Node[T <% Ordered[T]](var data: T, var left: Option[Node[T]], var right: Option[Node[T]]) {
  override def toString = data.toString
}

case class Tree[T <% Ordered[T]](var root: Option[Node[T]]) {

  def insert(item: T): Unit = {

    if (!root.isDefined) {
      root = Some(Node(item, None, None))
      return
    }

    var cur = root
    while (cur.isDefined)
      {
        val toCheck = cur.get
        val res = toCheck.data.compare(item)

        if (res==0)
          return
        else if (res < 0){
          if (toCheck.left.isEmpty) { toCheck.left = Some( Node(item, None, None) ); return }
          else { cur = toCheck.left }
        } else {
          if (toCheck.right.isEmpty) { toCheck.right = Some( Node(item, None, None) ); return }
          else { cur = toCheck.right }
        }
      }

  }


  def inOrder(node: Node[T]): Unit ={
    if (node.left.isDefined) { inOrder(node.left.get) }
    println(node)
    if (node.right.isDefined) { inOrder(node.right.get) }
  }


  def inOrder() {
    inOrder(root.get)
  }

}
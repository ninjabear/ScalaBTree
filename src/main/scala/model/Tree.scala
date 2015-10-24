package model

import scala.collection.mutable.ListBuffer

/**
 * ScalaBTree / Ed 
 * 24/10/2015 16:26
 */
case class Node[T <% Ordered[T]](var data: T, var left: Option[Node[T]], var right: Option[Node[T]]) {
  override def toString = data.toString
}

case class Tree[T <% Ordered[T]](rootItem: T) {

  private var root: Option[Node[T]] = None

  def add(item: T): Unit = {

    if (root.isEmpty) {
      root = Some(Node(rootItem, None, None))
    }

    var cur = root
    while (cur.isDefined) {

      val toCheck = cur.get
      val res = toCheck.data.compare(item)

      if (res == 0)
        return
      else if (res < 0) {

        if (toCheck.left.isEmpty) {
          toCheck.left = Some(Node(item, None, None)); return
        }
        else {
          cur = toCheck.left
        }

      } else {

        if (toCheck.right.isEmpty) {
          toCheck.right = Some(Node(item, None, None)); return
        }
        else {
          cur = toCheck.right
        }

      }
    }

  }

  private def inOrder(node: Node[T], order: ListBuffer[Node[T]]): ListBuffer[Node[T]] = {

    if (node.left.isDefined) {
      inOrder(node.left.get, order)
    }

    order += node

    if (node.right.isDefined) {
      inOrder(node.right.get, order)
    }

    order
  }


  def inOrder(): List[Node[T]] = {
    inOrder(root.get, ListBuffer()).toList
  }

}
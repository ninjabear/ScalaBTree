package model

import org.specs2.mutable.Specification

/**
 * ScalaBTree / Ed 
 * 24/10/2015 19:45
 */
class TreeSpec extends Specification {

  "inOrder traversal" should {
    "be sorted and contain all elements" in {
      val tree = Tree(2)
      tree.add(5)
      tree.add(9)
      tree.add(8)
      tree.add(22)

      tree.inOrder must have size 5
      tree.inOrder.map(x => x.data) must contain(allOf(5, 2, 9, 8, 22))
      tree.inOrder.reverse.map(x => x.data) must beSorted
    }
  }

}

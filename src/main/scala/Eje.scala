/*
object Solution {

  /*
   * Complete the simpleArraySum function below.
   */
    /*
     * Write your code here.
     */
    def compareTriplets(a: Array[Int], b: Array[Int]): Array[Int] = {

      val res = Array(0,0)
      for (w <- 0 to 2){
        if (a(w) > b(w)) {res(0)+=1}
        if (a(w) < b(w)) {res(1)+=1}
      }
      res
    }

  def diagonalDifference(arr: Array[Array[Int]]): Int = {
    // Write your code here
    var v1 = 0;
    var v2 = 0;
    for (w <- 0 to arr.length - 1){
      v1 += arr(w)(w)
      v2 += arr(w)(arr.length - 1 - w)
    }
    (v1 - v2).abs

  }



  def main(args: Array[String]) {

  }
}*/
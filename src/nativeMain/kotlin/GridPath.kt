import kotlin.time.measureTime

class GridPath {

     fun griPath(n: Int, m:Int) : Int{
            var memo = HashMap<Pair<Int, Int>, Int>();

         for (i in 1..n){
             memo[Pair(i, 1)] = 1
         }
        for (j in 1..m){
            memo[Pair(1, j)] = 1
        }
         for (i in 2..n){
             for (j in 2..m){
                 memo[Pair(i, j)] = memo[Pair(i - 1, j)]!! + memo[Pair(i, j - 1)]!!
             }
         }
         return memo[Pair(n, m)]!!;
     }
 }

 fun main(){
     val gridPath = GridPath();
     println("Value : " + gridPath.griPath(18, 6));
     println("Execution time : " + measureTime { gridPath.griPath(18, 6) });
 }

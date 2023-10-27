package dynamic

import kotlin.time.measureTime

class MinimumCoins() {

    var memo = HashMap<Int, Int>();

    fun minimumCoins(m:Int, coins:List<Int>): Int?{

        var answer: Int? = null;
        if (m==0) answer = 0;
        else {
            for (coin in coins){
                var subProblem = m - coin;
                if (subProblem >= 0){
                    answer = minIgnoreNone(answer, minimumCoins(subProblem, coins)?.plus(1));
                }
            }
        }
        return answer;
    }

    fun minimumCoinsDynamic(m:Int, coins:List<Int>): Int?{

        if (m in memo) return memo[m];

        var answer: Int? = null;
        if (m==0) answer = 0;
        else {
            for (coin in coins){
                var subProblem = m - coin;
                if (subProblem >= 0){
                    answer = minIgnoreNone(answer, minimumCoinsDynamic(subProblem, coins)?.plus(1));
                }
            }
        }
        memo[m] = answer!!;
        return answer;
    }

    fun minIgnoreNone(a: Int?, b: Int?): Int?{
        if (a == null) return b;
        if (b == null) return a;
        return if (a < b) a else b;
    }

}


private fun main(){
    val minimumCoins = MinimumCoins();
    println("Value : " + minimumCoins.minimumCoins(13, listOf(1, 4, 5)));
    println("Execution time : " + measureTime { minimumCoins.minimumCoins(13, listOf(1, 4, 5)) });
    println("Iterative dynamic")
    println("Value : " + minimumCoins.minimumCoinsDynamic(13, listOf(1, 4, 5)))
    minimumCoins.memo = HashMap<Int, Int>();
    println("Execution time : " + measureTime { minimumCoins.minimumCoinsDynamic(13, listOf(1, 4, 5))
    });

}
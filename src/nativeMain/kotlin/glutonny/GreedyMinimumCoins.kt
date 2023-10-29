package glutonny

import kotlin.math.min

class GreedyMinimumCoins {

    var memo = HashMap<Int, Int>()

    fun minimumCoins(m: Int, coins: List<Int>): Int? {
        var value = m;
        var answer: Int? = 0;
        while (value > 0) {
            var min = Int.MAX_VALUE;
            for (coin in coins) {
                if (coin <= value) {
                    min = min(min, coin);
                }
            }
            value -= min;
            answer = answer?.plus(1);
        }
        return if (m==0) answer;
        else null;
    }

    fun launch(){
        println("Value : " + minimumCoins(130, listOf(1, 4, 5)));
    }

}
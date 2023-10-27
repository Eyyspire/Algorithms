package dynamic

import kotlin.time.measureTime

class Fibonacci{
    fun naiveFib(n: Int): Int {
        return if (n <= 1) n else naiveFib(n - 1) + naiveFib(n - 2)
    }

    fun iterativeDynFib(n: Int): Int{
        var memo = HashMap<Int, Int>();
        for (i in 0..n){
            if (i <= 2) memo[i] = 1
            else memo[i] = memo[i - 1]!! + memo[i - 2]!!
        }
        return memo[n]!!;
    }
}

private fun main(){
    val fib = Fibonacci()
    println("Value : " + fib.naiveFib(20))
    println("Execution time : " + measureTime { fib.naiveFib(20) });
    println("Iterative dynamic")
    println("Value : " + fib.iterativeDynFib(20))
    println("Execution time : " + measureTime { fib.iterativeDynFib(20) });
}
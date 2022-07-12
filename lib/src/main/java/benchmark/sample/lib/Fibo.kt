package benchmark.sample.lib

fun fibo(n: Long): Long {
  //println("fibo $n")
  return when(n) {
    0L -> 0
    1L -> 1
    else -> fibo(n - 1) + fibo(n - 2)
  }
}

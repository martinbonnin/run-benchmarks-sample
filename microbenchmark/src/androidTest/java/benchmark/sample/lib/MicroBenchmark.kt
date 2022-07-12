package benchmark.sample.lib

import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import org.junit.Rule
import org.junit.Test

class MicroBenchmark {
  @get:Rule
  val benchmarkRule = BenchmarkRule()

  var i = 0
  @Test
  fun fibo_32() = benchmarkRule.measureRepeated {
    i++
    fibo(32)
  }
}
package benchmark.sample.lib

import androidx.benchmark.Outputs
import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import org.intellij.lang.annotations.Language
import org.junit.Rule
import org.junit.Test
import java.io.File

class MicroBenchmark {
  @get:Rule
  val benchmarkRule = BenchmarkRule()

  var i = 0

  @Test
  fun fibo_32() = benchmarkRule.measureRepeated {
    i++
    fibo(32)
  }

  @Test
  fun cacheSize() {
    benchmarkRule.measureRepeated {
      println(mapOf("key" to "value"))
    }

    Outputs.writeFile("extraMetrics.json", "extraMetrics", true) {
      @Language("Json")
      val content: String = """
        [
          {
            "name": "bytes",
            "value": 32000,
            "tags": ["class:MicroBenchmark", "test:cacheSize"]   
          }
        ]
      """.trimIndent()

      it.writeText(content)
    }
  }
}
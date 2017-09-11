import junit.framework.Assert.assertEquals
import model.Model
import org.junit.Test


class TestIt{


    @Test
    fun smallData(){
        val testModel = Model()
        var testList = listOf(2,1)
        var expected2 = listOf(2,1)
        assertEquals(expected2, testModel.largestPermutation(testList, 1, 2))
    }

    @Test
    fun testSwap(){
        val model=Model()
        assertEquals(listOf(1,2), model.swap(listOf(2,1), 0,1))
        assertEquals(listOf(12,24,56,23), model.swap(listOf(56,24,12,24), 0,2))
        assertEquals(listOf(12,24,56,23), model.swap(listOf(24,24,56,12), 0,3))
    }

    @Test
    fun testAReallyBigOne(){
        val testModel = Model()
        val dataLines = TestIt::class.java.getResource("testInput.txt").readText()
        val expected = TestIt::class.java.getResource("expected.txt").readText().split(" ").map { s->s.toInt() }.toMutableList()
        val swaps = dataLines.split(System.lineSeparator()).get(0).split(" ").get(1).toInt()
        var numNumers = dataLines?.split(" ")?.get(0)?.toInt()
        val data = dataLines.split(System.lineSeparator()).get(1).split(" ").map{s->s.toInt()}.toMutableList()
        var result = testModel.largestPermutation(data,swaps, numNumers)
        result.forEach { println(it) }
        assertEquals(expected, result)
    }

    @Test
    fun testAnotherBigOne(){
        val testModel = Model()
        val dataLines = TestIt::class.java.getResource("testInput2.txt").readText()
        val expected = TestIt::class.java.getResource("expected2.txt").readText().split(" ").map { s->s.toInt() }.toMutableList()
        val swaps = dataLines.split(System.lineSeparator()).get(0).split(" ").get(1).toInt()
        var numNumers = dataLines?.split(" ")?.get(0)?.toInt()
        val data = dataLines.split(System.lineSeparator()).get(1).split(" ").map{s->s.toInt()}.toMutableList()
        var result = testModel.largestPermutation(data, swaps, numNumers)

        result.forEach { println(it) }
        assertEquals(expected, result)
    }
}

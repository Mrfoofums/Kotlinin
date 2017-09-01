import junit.framework.Assert.assertEquals
import model.Model
import org.junit.Test


class TestIt{

    @Test
    fun testIt(){
        val testModel = Model()
//        assertEquals(listOf(5, 4, 3, 2, 1), testModel.largestPermutation(listOf(4, 5, 3, 2, 1), 1))

    }

    @Test
    fun testTwoSwaps(){
        val testModel = Model()
        var testList = listOf(6,9,6,5,4,3,7)
        var expected2 = listOf(9,7,6,5,4,3,6)
        var sortedMap = testModel.convertListToSortedListOfMaps(testList)

        assertEquals(expected2, testModel.largestPermutation(testList, 2, sortedMap))
    }

    @Test
    fun testConvertListToMap(){
        val testModel = Model()
        var testList = listOf(6,9,6,5,4,3,7)

        var sortedMap = testModel.convertListToSortedListOfMaps(testList)

        sortedMap.asSequence().forEachIndexed { index, entry ->
            println("${index} : ${entry}")
        }
    }

    @Test
    fun smallData(){
        val testModel = Model()
        var testList = listOf(2,1)
        var expected2 = listOf(2,1)
//        assertEquals(expected2, testModel.largestPermutation(testList, 1))
    }

    @Test
    fun testSwap(){
        val model=Model()
        assertEquals(listOf(1,2), model.swap(listOf(2,1), 0,1))
        assertEquals(listOf(12,24,56,24), model.swap(listOf(56,24,12,24), 0,2))
        assertEquals(listOf(12,24,56,24), model.swap(listOf(24,24,56,12), 0,3))
    }

    @Test
    fun testGetIndexOfLargestValue(){
        val testModel = Model()
        val testList = listOf(6,900000,6,5,4,3,7,900,42,36,11,20,40,6,40000)
        val expected = 1

        assertEquals(expected, testModel.getIndexOfLargestValue(testModel.convertListToSortedListOfMaps(testList), 0))

    }
    @Test
    fun testGetIndexOfLargestValueSmallDataSet(){
        val testModel = Model()
        val testList = listOf(6,900000)
        val expected = 1

        assertEquals(expected, testModel.getIndexOfLargestValue(testModel.convertListToSortedListOfMaps(testList), 0))

    }

    @Test
    fun testAReallyBigOne(){
        val testModel = Model()
        val dataLines = TestIt::class.java.getResource("testInput.txt").readText()
        val expected = TestIt::class.java.getResource("expected.txt").readText().split(" ").map { s->s.toInt() }.toMutableList()
        val swaps = dataLines.split(System.lineSeparator()).get(0).split(" ").get(1).toInt()
        println("Swaps is $swaps")
        val data = dataLines.split(System.lineSeparator()).get(1).split(" ").map{s->s.toInt()}.toMutableList()
//

    }

    @Test
    fun testAnotherBigOne(){
        val testModel = Model()
        val dataLines = TestIt::class.java.getResource("testInput2.txt").readText()
        val expected = TestIt::class.java.getResource("expected2.txt").readText().split(" ").map { s->s.toInt() }.toMutableList()
        val swaps = dataLines.split(System.lineSeparator()).get(0).split(" ").get(1).toInt()
        println("Swaps is $swaps")
        val data = dataLines.split(System.lineSeparator()).get(1).split(" ").map{s->s.toInt()}.toMutableList()

    }

}

package model


import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class Model{

fun main(args: Array<String>) {
    var inputs = readLine()
    var data = readLine()?.split(" ")?.map { s -> s.toInt() }
    var swaps = inputs?.split(" ")?.get(1)?.toInt()
    var sortedMap: SortedMap<Int,Int>

    if(data != null && swaps != null) {
        sortedMap = convertListToSortedListOfMaps(data)//Descending
        val answer =largestPermutation(data, swaps, sortedMap)
        answer.forEach { s -> print("$s ") }
    }
}

fun largestPermutation(integerList: List<Int>, swaps:Int, sortedMap: SortedMap<Int, Int>): List<Int>{
    var answerList:List<Int> = integerList.toMutableList()
    var curIndex = 0
    var swapsUsed = swaps
    while(curIndex < swapsUsed && curIndex < integerList.size){
//        var swapIndex = getIndexOfLargestValue(sortedMap,0)
//        if(swapIndex !=curIndex){
//            answerList = swap(answerList, curIndex , swapIndex)
//            curIndex+=1
//        }
//        else {
//            curIndex+=1
//            swapsUsed+=1
//        }
    }

    return answerList
}

    fun swap(integerList:List<Int>, ind1:Int, ind2:Int ):List<Int>{
        var swap1 = integerList[ind1]
        var swap2 = integerList[ind2]

        var newList = integerList.toMutableList()
        newList[ind2] = swap1
        newList[ind1] = swap2


        return newList
    }

    /**
     * Returns the index from the original data set of the element we need to swap with
     */
    fun getIndexOfLargestValue(sortedMap:SortedMap<Int,Int>, startLookingIndex:Int):Int{
        var indexToReturn:Int= startLookingIndex
        sortedMap.asSequence().forEachIndexed { index, entry ->
            if(index == startLookingIndex){
                indexToReturn = entry.value.toInt()
                return@forEachIndexed
            }
         }
        return indexToReturn
    }

    fun convertListToSortedListOfMaps(paramList:List<Int>):List<Map<Int,Int>>{
        var sortedList = paramList.sorted().reversed()
        var listOfMaps:MutableCollection<List>
       for (i in 0 until sortedList.size){
           var localMap = HashMap<Int,Int>().put(sortedList[i],i)
            listOfMaps.add(localMap)
       }
        var sortedMap = map.toSortedMap()
        return sortedMap
    }

}








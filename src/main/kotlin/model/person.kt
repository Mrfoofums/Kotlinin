package model


class Model{

fun main(args: Array<String>) {
    var inputs = readLine()
    var data = readLine()?.split(" ")?.map { s -> s.toInt() }
    var swaps = inputs?.split(" ")?.get(1)?.toInt()
    var numNumers = inputs?.split(" ")?.get(0)?.toInt()
    if(data != null && swaps != null && numNumers != null) {
        val answer =largestPermutation(data, swaps, numNumers)
        answer.forEach { s -> print("$s ") }
    }
}

fun largestPermutation(paramList: List<Int>, swaps:Int, numNumbers:Int): List<Int>{
    var answerList:List<Int> = paramList.toMutableList()
    var curIndex = 0
    var valueMap = getSortedMapOfValues(paramList)
    valueMap.forEach { item->
        println("(Key)Integer: ${item.key} CurIndexInArray:${item.value}")
    }

    while(curIndex < swaps && curIndex < paramList.size){
        var swapIndex = valueMap.get(numNumbers)
        if(swapIndex != null)
            answerList = swap(answerList, curIndex , swapIndex)
        curIndex+=1
        numNumbers-+1
    }

    return answerList
}

    fun swap(integerList:List<Int>, ind1:Int, ind2:Int ):MutableList<Int>{
        var swap1 = integerList[ind1]
        var swap2 = integerList[ind2]

        var newList = integerList.toMutableList()
        newList[ind2] = swap1
        newList[ind1] = swap2

        return newList
    }

    fun getSortedMapOfValues(paramList:List<Int>):MutableMap<Int,Int>{
        var numberMap = mutableMapOf<Int,Int>()
        paramList.forEachIndexed { index, i ->
            numberMap.put(i, index)
        }
        return numberMap
    }
}
//Need to track swaps in number map thingy
class NumberDescriptor(var currentIndex:Int, val value:Int) : Comparable<NumberDescriptor> {
    override fun compareTo(other: NumberDescriptor): Int {
        return other.value.compareTo(this.value)
    }
}











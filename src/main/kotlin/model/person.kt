package model


import java.util.*
class Model{

fun main(args: Array<String>) {
    var inputs = readLine()
    var data = readLine()?.split(" ")?.map { s -> s.toInt() }
    var swaps = inputs?.split(" ")?.get(1)?.toInt()

    if(data != null && swaps != null) {
        val answer =largestPermutation(data, swaps)
        answer.forEach { s -> print("$s ") }
    }
}

fun largestPermutation(integerList: List<Int>, swaps:Int): List<Int>{
    var answerList:List<Int> = integerList.toMutableList()
    var curIndex = 0
    var swapsUsed = swaps
    val sortedDescriptorList = getSortedListOfNumberDescriptor(integerList)
    while(curIndex < swapsUsed && curIndex < integerList.size){
        var swapIndex = sortedDescriptorList[curIndex].originIndex
        if(swapIndex !=curIndex){
            answerList = swap(answerList, curIndex , swapIndex)
            curIndex+=1
        }
        else {
            curIndex+=1
            swapsUsed+=1
        }
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

    fun getSortedListOfNumberDescriptor(paramList:List<Int>):List<NumberDescriptor>{
        var answerList = mutableListOf<NumberDescriptor>()
        (0 until paramList.size).mapTo(answerList) { NumberDescriptor(it, paramList[it]) }.sort()
        return answerList
    }
}

class NumberDescriptor(val originIndex:Int, val value:Int) : Comparable<NumberDescriptor> {
    override fun compareTo(other: NumberDescriptor): Int {
        return other.value.compareTo(this.value)
    }

}











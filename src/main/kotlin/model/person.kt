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

fun largestPermutation(paramList: List<Int>, swaps:Int, neededValueAtCurrentIndex:Int): List<Int>{
    var answerList:List<Int> = paramList.toMutableList()
    var currentIndexInOriginalArray = 0
    var valueMap = getSortedMapOfValues(paramList)
    var currentNeededVal = neededValueAtCurrentIndex
    while(currentIndexInOriginalArray < swaps && currentIndexInOriginalArray < paramList.size){
        //Get Index of curValue, which starts at the first value
        var currentValueAtCurIndex = paramList[currentIndexInOriginalArray]
        if(currentValueAtCurIndex != currentNeededVal){
            //we need to swap whatver is at the currentIndexInOriginalArray with what is at indexOfNextValue
            valueMap = swap(valueMap , currentValueAtCurIndex , currentNeededVal)
            //Increment stuff
            currentIndexInOriginalArray+=1
            currentNeededVal-=1
        }
        else{
            currentIndexInOriginalArray+=1
        }
    }
    valueMap.forEach { item->
        println("(Key)Integer: ${item.key} CurIndexInArray:${item.value}")
    }
    //Need to somehow print the array in valueMap index order...
    //TODO ^
    return answerList
}

    fun swap(numberMap:MutableMap<Int, Int>, currentValue:Int, neededValue:Int ):MutableMap<Int, Int>{

        var indexOfCurrentValue = numberMap.get(currentValue)
        var indexOfNeededValue = numberMap.get(neededValue)
        numberMap.remove(currentValue)
        numberMap.remove(neededValue)
        if(indexOfCurrentValue!= null && indexOfNeededValue!= null) {
            numberMap.put(currentValue, indexOfNeededValue)
            numberMap.put(neededValue, indexOfCurrentValue)
        }
        return numberMap
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











package divideAndConquer

class MergeSort {

    fun mergeSort(list:List<Int>): List<Int>{
        if (list.size <= 1) return list;

        else{
            var mid = list.size / 2;
            var left = list.subList(0, mid);
            var right = list.subList(mid, list.size);
            return merge(mergeSort(left), mergeSort(right));
        }
    }

    fun merge(l1:List<Int>, l2:List<Int>): List<Int> {
        var i = 0;
        var j = 0;
        var mergedList = mutableListOf<Int>();
        while(i < l1.size && j < l2.size){
            if (l1[i] < l2[j]){
                mergedList.add(l1[i]);
                i++;
            }
            else{
                mergedList.add(l2[j]);
                j++;
            }
        }
        if(i < l1.size){
            mergedList.addAll(l1.subList(i, l1.size));
        }
        if(j < l2.size){
            mergedList.addAll(l2.subList(j, l2.size));
        }
        return mergedList;
    }

    fun launch(){
        println("Value : " + this.mergeSort(List(1000000){it}.shuffled()))
    }
}
package week1
/** row major */
class Array2D<T>(val n:Int, val m:Int, private val arr:Array<T>) {
    init {
        require(n*m == arr.size)
    }
    companion object {
        inline fun <reified T> array2d(n:Int, m:Int, v:T) =
            Array2D<T>(n,m,Array<T>(n*m){v})

        inline fun <reified T> array2d(n:Int, m:Int, block:(Int,Int)->T) =
            Array2D<T>(n,m,Array<T>(n*m){ i ->
                val row = i/n
                val col = i%m
                block(row,col)
            })
    }

    operator fun get(i: Int, j:Int): T{

        return arr[(i-1)*n + (j-1)]
    }
    operator fun set(i: Int, j:Int, v:T): Unit{
        arr[(i-1)*n + (j-1)] = v
    }
}

fun main() {
    var arr1 = Array2D.array2d(3,3,0.0)
    arr1[0,0] = 10.0
    println(arr1[0,0])

    var arr2 = Array2D.array2d(2,3){ i,j ->
        "$i,$j"
    }
    arr2[1,2] = "test"
    println(arr2[1,2])
}
package week1

/**
 * fun <T:Any> arraycopy(src: Array<T>, srcPos: Int,dest: Array<T>,destPos: Int, length:Int) 를 구현하라
 * src와 dest가 같은 배열일 수 있다
 * 범위 검사를 철저히 하라
 * 예:
 *   arrayCopy(arrayOf(1,2,3), 0, arrayOf(4,5,6), 0, 3)
 *   // arrayOf(4,5,6)의 내용이 1,2,3으로 바뀜
 *   val x =  arrayOf(1,2,3,4,5,6)
 *   arrayCopy(x,0,x,3,1)    // x가 1,2,3,1,5,6 으로 바뀜
 *   arrayCopy(x,2,x,0,4)    // x가 3,1,5,6,5,6
 *   arrayCopy(x,0,x,1,5)    // 잘못 구현하면 데이터가 파괴될 수 있음 주의 필요
 * */

fun <T:Any> arraycopy(src: Array<T>, srcPos: Int, dest: Array<T>, destPos: Int, length: Int){

    if(srcPos + length > src.size || destPos + length > dest.size) return // 범위 벗어날 때
    if(src.contentEquals(dest) && srcPos == destPos) return // 같을 때

    if(src.contentEquals(dest)){
        if(srcPos > destPos){
            for(i in 0..<length){
                dest[destPos + i] = src[srcPos + i]
            }
        }else{
            for(i in length-1 downTo  0){
                dest[destPos + i] = src[srcPos + i]
            }
        }
    }
    else{
        for(i in 0..<length){
            dest[destPos + i] = src[srcPos + i]
        }
    }
}

fun main(){
    val x = arrayOf(1, 2, 3, 4, 5, 6)
    val y = arrayOf(1, 2, 3, 4, 5, 6)
    println(x.joinToString(" "))

    arraycopy(x, 0, x, 3, 1)
    println(x.joinToString(" "))

    arraycopy(x, 2, x, 0, 4)
    println(x.joinToString(" "))

    arraycopy(x, 0, x, 1, 5)
    println(x.joinToString(" "))

}
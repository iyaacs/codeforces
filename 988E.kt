import java.io.PrintWriter
import java.lang.Integer.min
import java.util.*
import java.util.Collections.swap
import kotlin.math.max

@JvmField
val INPUT = System.`in`
@JvmField
val OUTPUT = System.out

@JvmField
val _reader = INPUT.bufferedReader()
fun readLine(): String? = _reader.readLine()
fun readLn() = _reader.readLine()!!
@JvmField
var _tokenizer: StringTokenizer = StringTokenizer("")
fun read(): String {
    while (_tokenizer.hasMoreTokens().not()) _tokenizer = StringTokenizer(_reader.readLine() ?: return "", " ")
    return _tokenizer.nextToken()
}

fun readInt() = read().toInt()
fun readDouble() = read().toDouble()
fun readLong() = read().toLong()
fun readStrings(n: Int) = List(n) { read() }
fun readLines(n: Int) = List(n) { readLn() }
fun readInts(n: Int) = List(n) { read().toInt() }
fun readIntArray(n: Int) = IntArray(n) { read().toInt() }
fun readDoubles(n: Int) = List(n) { read().toDouble() }
fun readDoubleArray(n: Int) = DoubleArray(n) { read().toDouble() }
fun readLongs(n: Int) = List(n) { read().toLong() }
fun readLongArray(n: Int) = LongArray(n) { read().toLong() }

@JvmField
val _writer = PrintWriter(OUTPUT, false)
inline fun output(block: PrintWriter.() -> Unit) {
    _writer.apply(block).flush()
}

fun get(cache: HashMap<Char, Int>, key: Char) : Int{
    if(!cache.containsKey(key)){
        return 0
    }
    return cache[key]!!
}


fun solve(s: String) : Int{
    var cache = HashMap<Char, Int>();
    for(c in s.toCharArray()){
       if(!cache.containsKey(c)){
           cache[c]=0
       }
        cache[c] = cache[c]!! + 1
    }
    if (
        get(cache, '0') < 2
        && (get(cache, '2') == 0 || get(cache, '5') == 0)
        && (get(cache, '5') == 0 || get(cache, '0') == 0)
        && (get(cache, '7') == 0 || get(cache, '5') == 0)
    )
    {
        return -1
    }
    var ret = s.length * 2

    if(get(cache, '0') >= 2){
        var s2 = s.reversed()
        var s3 = s2.toCharArray()
        var cnt = 0
        var idx = s2.indexOf('0')
        for(i in idx downTo 1) {
            var c = s3[i-1]
            s3[i-1] = s3[i]
            s3[i] = c
            cnt += 1
            //println(s3)
        }
        s2 = String(s3)
        idx = s2.indexOf('0', 1)
        for(i in idx downTo 2) {
            var c = s3[i-1]
            s3[i-1] = s3[i]
            s3[i] = c
            cnt += 1
            //println(s3)
        }
        s2 = String(s3).reversed()
        var _cnt = s.length * 2
        for(c in "123456789".toCharArray()){
            var v = s2.indexOf(c)
            if (v<0){continue;}
            _cnt = min(_cnt, v)
        }
        //println(cnt)
        ret = min(ret, cnt + _cnt)
    }
    if(get(cache, '2') > 0 && get(cache, '5') > 0) {
        var s2 = s.reversed()
        var s3 = s2.toCharArray()
        var cnt = 0
        var idx = s2.indexOf('5')
        for(i in idx downTo 1) {
            var c = s3[i-1]
            s3[i-1] = s3[i]
            s3[i] = c
            cnt += 1
            //println(s3)
        }
        s2 = String(s3)
        idx = s2.indexOf('2', 1)
        for(i in idx downTo 2) {
            var c = s3[i-1]
            s3[i-1] = s3[i]
            s3[i] = c
            cnt += 1
            //println(s3)
        }
        s2 = String(s3).reversed()
        var _cnt = s.length * 2
        for(c in "123456789".toCharArray()){
            var v = s2.indexOf(c)
            if (v<0){continue;}
            _cnt = min(_cnt, v)
        }
        //println(cnt)
        ret = min(ret, cnt + _cnt)
    }
    if(get(cache, '5') > 0 && get(cache, '0') > 0) {
        var s2 = s.reversed()
        var s3 = s2.toCharArray()
        var cnt = 0
        var idx = s2.indexOf('0')
        for(i in idx downTo 1) {
            var c = s3[i-1]
            s3[i-1] = s3[i]
            s3[i] = c
            cnt += 1
            //println(s3)
        }
        s2 = String(s3)
        idx = s2.indexOf('5', 1)
        for(i in idx downTo 2) {
            var c = s3[i-1]
            s3[i-1] = s3[i]
            s3[i] = c
            cnt += 1
            //println(s3)
        }
        s2 = String(s3).reversed()
        var _cnt = s.length * 2
        for(c in "123456789".toCharArray()){
            var v = s2.indexOf(c)
            if (v<0){continue;}
            _cnt = min(_cnt, v)
        }
        //println(cnt)
        ret = min(ret, cnt + _cnt)
    }
    if(get(cache, '7') > 0 && get(cache, '5') > 0) {
        var s2 = s.reversed()
        var s3 = s2.toCharArray()
        var cnt = 0
        var idx = s2.indexOf('5')
        for(i in idx downTo 1) {
            var c = s3[i-1]
            s3[i-1] = s3[i]
            s3[i] = c
            cnt += 1
            //println(s3)
        }
        s2 = String(s3)
        idx = s2.indexOf('7', 1)
        for(i in idx downTo 2) {
            var c = s3[i-1]
            s3[i-1] = s3[i]
            s3[i] = c
            cnt += 1
            //println(s3)
        }
        s2 = String(s3).reversed()
        var _cnt = s.length * 2
        for(c in "123456789".toCharArray()){
            var v = s2.indexOf(c)
            if (v<0){continue;}
            _cnt = min(_cnt, v)
        }
        //println(cnt)
        ret = min(ret, cnt + _cnt)
    }
    return ret
}

fun main(args: Array<String>) {
    var s = readLine()!!
    println(solve(s))
}
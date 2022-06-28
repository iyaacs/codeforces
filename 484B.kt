import java.io.PrintWriter
import java.util.*
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


fun lower_bound(arr: IntArray, key: Int): Int {
    var index = Arrays.binarySearch(arr, key)
    if (index < 0) {
        return Math.abs(index) - 1;
    } else {
        while (index > 0) {
            if (arr[index - 1] == key) {
                index--
            } else {
                return index
            }
        }
        return index
    }
}

fun main(args: Array<String>) {
    var ans = 0
    var maxi = -1
    var range = -1

    var n = readInt()
    var arr = readIntArray(n)
    arr.sort()

    for (i in arr.indices) {
        if (i > 0 && arr[i] == arr[i - 1]) {
            continue
        }
        var tmp = arr[i] * 2
        range = arr.last() / arr[i]
        range = (range + 1) * arr[i]

        while (tmp <= range) {
            var p = lower_bound(arr, tmp)
            if (p > 0) {
                ans = max(ans, arr[p - 1] % arr[i])
            }
            tmp += arr[i]
        }
    }
    println(ans)
}
fun main() {
    print("Nhập số lượng phân số: ")
    val n = readln().toInt()
    val arr = Array(n) { PhanSo(1, 1) }

    // Nhập mảng
    for (i in arr.indices) {
        println("Nhập phân số thứ ${i + 1}:")
        arr[i].nhap()
    }

    println("\nMảng phân số vừa nhập:")
    arr.forEach { it.inPhanSo() }

    println("\nMảng sau khi tối giản:")
    arr.forEach {
        it.toiGian()
        it.inPhanSo()
    }

    // Tính tổng
    var tong = arr[0]
    for (i in 1 until n) {
        tong = tong.sum(arr[i])
    }
    println("\nTổng các phân số:")
    tong.inPhanSo()

    // Tìm phân số lớn nhất
    var max = arr[0]
    for (i in 1 until n) {
        if (arr[i].soSanh(max) == 1) {
            max = arr[i]
        }
    }
    println("\nPhân số lớn nhất:")
    max.inPhanSo()

    // Sắp xếp giảm dần
    val sortedArr = arr.sortedWith { a, b -> -a.soSanh(b) }
    println("\nMảng sau khi sắp xếp giảm dần:")
    sortedArr.forEach { it.inPhanSo() }
}
import kotlin.math.abs

// Lớp PhanSo đại diện cho một phân số với tử số và mẫu số
class PhanSo(var tu: Int, var mau: Int) {

    /**
     * Hàm nhập phân số từ bàn phím
     * Yêu cầu: tử số và mẫu số phải là số nguyên, mẫu số khác 0
     * Tham số: không có
     * Trả về: không có, gán trực tiếp vào thuộc tính tu và mau
     */
    fun nhap() {
        while (true) {
            print("Nhap tu so: ")
            val inputTu = readln().toIntOrNull() // đọc tử số, kiểm tra hợp lệ
            if (inputTu == null) {
                println("Tu so phai la so nguyen!")
                continue
            }

            print("Nhap mau so: ")
            val inputMau = readln().toIntOrNull() // đọc mẫu số, kiểm tra hợp lệ
            if (inputMau == null) {
                println("Mau so phai la so nguyen!")
                continue
            }

            if (inputMau == 0) { // mẫu số không được bằng 0
                println("Mau khong duoc bang 0! Vui long nhap lai!")
                continue
            }

            // nếu hợp lệ, gán giá trị và thoát vòng lặp
            tu = inputTu
            mau = inputMau
            break
        }
    }

    /**
     * Hàm in phân số ra màn hình
     * Tham số: không có
     * Trả về: không có, chỉ in ra dạng "tu/mau"
     */
    fun inPhanSo(){
        println("$tu/$mau")
    }

    /**
     * Hàm tối giản phân số
     * Tham số: không có
     * Trả về: không có, gán trực tiếp vào tu và mau
     */
    fun toiGian(){
        val gcd = ucln(abs(tu), abs(mau)) // tìm ước chung lớn nhất
        tu /= gcd
        mau /= gcd
        if(mau < 0){ // đảm bảo mẫu dương
            tu = -tu
            mau = -mau
        }
    }

    /**
     * Hàm so sánh phân số với một phân số khác
     * Tham số:
     *  - psm: PhanSo cần so sánh
     * Trả về:
     *  - 1 nếu phân số hiện tại > psm
     *  - -1 nếu phân số hiện tại < psm
     *  - 0 nếu bằng nhau
     */
    fun soSanh(psm: PhanSo): Int{
        val cheo1 = tu * psm.mau
        val cheo2 = mau * psm.tu
        return when {
            cheo1 > cheo2 -> 1
            cheo2 > cheo1 -> -1
            else -> 0
        }
    }

    /**
     * Hàm tính tổng với một phân số khác
     * Tham số:
     *  - ps: phân số cần cộng
     * Trả về:
     *  - một PhanSo mới là kết quả tổng, đã tối giản
     */
    fun sum(ps: PhanSo): PhanSo {
        val tuMoi = tu * ps.mau + ps.tu * mau
        val mauMoi = mau * ps.mau
        val kq = PhanSo(tuMoi, mauMoi)
        kq.toiGian()
        return kq
    }

    companion object {
        /**
         * Hàm tính ước chung lớn nhất (Greatest Common Divisor)
         * Tham số: a, b: 2 số nguyên
         * Trả về: số nguyên là ước chung lớn nhất của a và b
         */
        fun ucln(a: Int, b: Int): Int {
            return if (b == 0) a else ucln(b, a % b)
        }
    }
}
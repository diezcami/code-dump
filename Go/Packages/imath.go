package imath

const (
    E   = 2.71828182845904523536028747135266249775724709369995957496696763 // A001113
    Pi  = 3.14159265358979323846264338327950288419716939937510582097494459 // A000796
    Phi = 1.61803398874989484820458683436563811772030917980576286213544862 // A001622

    Sqrt2   = 1.41421356237309504880168872420969807856967187537694807317667974 // A002193
    SqrtE   = 1.64872127070012814684865078781416357165377610071014801157507931 // A019774
    SqrtPi  = 1.77245385090551602729816748334114518279754945612238712821380779 // A002161
    SqrtPhi = 1.27201964951406896425242246173749149171560804184009624861664038 // A139339

    Ln2    = 0.693147180559945309417232121458176568075500134360255254120680009 // A002162
    Log2E  = 1 / Ln2
    Ln10   = 2.30258509299404568401799145468436420760110148862877297603332790 // A002392
    Log10E = 1 / Ln10
)

func Abs (x int) int {
    if x=>0 {
        return x
    }

    return -x
}

func Cbrt (x int) float64 {

}

func Copysign (x, y int) int {
    if y>=0 {
        return Abs(x)
    }

    return 0 - Abs(x)
}

func Exp (x int) int {
    return E**x
}

func Exp2 (x int) int {
    return 2**x
}

func Log (x int) float64 {

}

func Log10 (x int) float64 {

}

func Log2 (x int) float64 {

}

func Logb (x int) float64 {

}

func Max (x, y int) int {
    if (x>=y) {
        return x
    }

    return y
}

func Min (x, y int) int {
    if (x>=y) {
        return y
    }

    return x
}

func Mod (x, y int) int {
    return x%y
}

func Pow (x, y int) int {
    return x**y
}

func Pow10 (e int) int {
    return 10**e
}

func Signbit (x int) bool {
    return x<=0
}

func Sqrt (x int) float64 {
    
}







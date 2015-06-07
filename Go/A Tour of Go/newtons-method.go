package main

import (
    "fmt"
    "math"
)

func Sqrt(x float64) {
    for z:=1.0; z<5; z++ {
        result, success := CalcZ(x, z)
        if success {
            fmt.Println ("The NM square root of", x, "is", result)
            return;
        }
    }

    fmt.Println ("Cannot find the sqrt of", x, "using Newton's Method from z=1-5.")
    
}

func CalcZ(x, z float64) (float64, bool) {
    var prev float64;

    for i:=1; i<10; i++ {
        prev = z
        z = z-((math.Pow(z,2)-x)/2*z) // Newton's Method
        if CloseVal(prev, z) {
            return z, true;
        }
    }

    return z, false;
}

func CloseVal (prev, curr float64) bool {
    return math.Abs(curr) - math.Abs(prev) < 0.0001
}

func main() {
    for i:=1.0; i<17; i++ {
        Sqrt(i)
        fmt.Println ("The real square root of", i, "is", math.Sqrt(i))
    }
}


package main

import "fmt"

// fibonacci is a function that returns
// a function that returns an int.
func fibonacci() func() int {
    previous := 0
    current := 1
    return func () int {
        fib := previous + current
        previous = current
        current = fib
        return fib
    }
}

func main() {
    f := fibonacci()
    for i := 0; i < 10; i++ {
        fmt.Println(f())
    }
}


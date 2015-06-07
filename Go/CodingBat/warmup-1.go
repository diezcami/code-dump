package warmup1

import (
	"math"
	"strings"
)

/*
   The parameter weekday is True if it is a weekday, and the parameter vacation is True if we are on vacation. We sleep in if it is not a weekday or we're on vacation. Return True if we sleep in.
*/
func sleep_in(weekday, vacation bool) bool {
	if vacation {
		return true
	}
	return !weekday
}

/*
   We have two monkeys, a and b, and the parameters a_smile and b_smile indicate if each is smiling. We are in trouble if they are both smiling or if neither of them is smiling. Return True if we are in trouble.
*/
func monkey_trouble(a_smile, b_smile bool) bool {
	return a_smile && b_smile || !a_smile && !b_smile
}

/*
   Given two int values, return their sum. Unless the two values are the same, then return double their sum.
*/
func sum_double(a, b int) int {
	if a == b {
		return 4 * a
	}
	return a + b
}

/*
   Given an int n, return the absolute difference between n and 21, except return double the absolute difference if n is over 21.
*/
func diff21(n int) int {
	if n > 21 {
		return 2 * (n - 21)
	}
	return int(math.Abs(float64(n - 21)))
}

/*
   We have a loud talking parrot. The "hour" parameter is the current hour time in the range 0..23. We are in trouble if the parrot is talking and the hour is before 7 or after 20. Return True if we are in trouble.
*/
func parrot_trouble(talking bool, hour int) bool {
	return talking && (hour < 7 || hour > 20)
}

/*
   Given 2 ints, a and b, return True if one if them is 10 or if their sum is 10.
*/
func makes10(a, b int) bool {
	return a == 10 || b == 10 || a+b == 10
}

/*
   Given an int n, return True if it is within 10 of 100 or 200. Note: abs(num) computes the absolute value of a number.
*/
func near_hundred(n int) bool {
	return math.Abs(float64(100-n)) <= 10 || math.Abs(float64(200-n)) <= 10
}

/*
   Given 2 int values, return True if one is negative and one is positive. Except if the parameter "negative" is True, then return True only if both are negative.
*/
func pos_neg(a, b int, negative bool) bool {
	if negative {
		return a < 0 && b < 0
	}
	return (a < 0) != (b < 0)
}

/*
   Given a string, return a new string where "not " has been added to the front. However, if the string already begins with "not", return the string unchanged.
*/
func not_string(str string) string {
	if strings.HasPrefix(str, "not") {
		return str
	}
	return "not " + str
}

/*
   Given a non-empty string and an int n, return a new string where the char at index n has been removed. The value of n will be a valid index of a char in the original string (i.e. n will be in the range 0..len(str)-1 inclusive).
*/
func missing_char(str string, n int) string {
	return str[0:n] + str[n+1:]
}

/*
   Given a string, we'll say that the front is the first 3 chars of the string. If the string length is less than 3, the front is whatever is there. Return a new string which is 3 copies of the front.
*/
func front3(str string) string {
	if len(str) < 3 {
		return str + str + str
	}
	return str[0:3] + str[0:3] + str[0:3]
}

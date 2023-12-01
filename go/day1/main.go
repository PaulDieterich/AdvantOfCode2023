package main

import (
	"fmt"
	"os"
	"strconv"
	"strings"
	"unicode"
)

var nums = []string{"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"}

func main() {
	input, _ := os.ReadFile("./inputFile2.txt")

	total := 0
	lines := strings.Split(string(input), "\n")
	for _, line := range lines {
		fistIsFound := false
		sum := 0
		first := ""
		last := ""
		for i, c := range line {
			if unicode.IsDigit(c) {
				if !fistIsFound {
					fistIsFound = true
					first = string(c)
					last = string(c)
				} else {
					last = string(c)
				}
			} else {
				number := wordToInt(line[i:])
				if number > 0 {
					if !fistIsFound {
						fistIsFound = true
						first = strconv.Itoa(number)
						last = strconv.Itoa(number)
					} else {
						last = strconv.Itoa(number)
					}

				}
			}
		}
		sum, _ = strconv.Atoi(first + last)
		total += sum
	}
	fmt.Print(total)
}
func wordToInt(word string) int {
	for i, num := range nums {
		if strings.Index(word, num) == 0 {
			return i + 1
		}
	}
	return 0
}

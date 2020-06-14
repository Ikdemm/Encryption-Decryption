# Encryption-Decryption

This project is a solution for a problem proposed by JetBrains Academy.
The project is composed of a single main Java Class that accepts an array input and decrypt/encrypt it depending on the arguments

## How it works

The program reads an English message and an integer number (key) from the standard input and shifts each letter by the specified
number according to its order in the alphabet. If you reach the end of the alphabet, start back at the beginning (a follows z).

The program must parse two additional arguments -in and -out to specify the full name of a file to read data and to write the result.
Arguments -mode, -key, and -data should still work as before.

Your program should read data from -data or from a file written in the -in argument.
That's why you can't have both -data and -in arguments simultaneously, only one of them.

## Arguments

If there is no -mode, the program should work in enc mode.
If there is no -key, the program should consider that key = 0.
If there is no -data, and there is no -in the program should assume that the data is an empty string.
If there is no -out argument, the program must print data to the standard output.
If there are both -data and -in arguments, your program should prefer -data over -in.
If there is a non-standard situation (an input file does not exist or an argument doesn’t have a value), the program should not fail.
Instead, it must display a clear message about the problem and stop successfully.
The message should contain the word "Error" in any case.

## Examples

### Example 1

java Main -mode enc -in road_to_treasure.txt -out protected.txt -key 5
This command must get data from the file road_to_treasure.txt, encrypt the data with the key 5, create a file called protected.txt and write ciphertext to it.

### Example 2

Input:

java Main -mode enc -key 5 -data "Welcome to hyperskill!"

Output:

\jqhtrj%yt%m~ujwxpnqq&

### Example 3

Input:

java Main -key 5 -data "\jqhtrj%yt%m~ujwxpnqq&" -mode dec

Output:

Welcome to hyperskill!

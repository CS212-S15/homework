FileStats
=========
The main goal of the assignment is to verify that you are able to correctly use github and the submission system.

You  must implement the API provided in the FileStats class exactly. If you do not pass all tests you will not receive full credit.

In this first homework assignment you will write a simple program that reads in a file and counts the number of words in the file.

To make things a bit more interesting, the constructor of your FileStats class will take as input the Path of the file to be read and a boolean value to indicate how words (or tokens) in the file should be determined. If the value is true, then anything *except* upper and lower-case letters should be considered a delimiter. If the value is false then anything *except* upper and lower-case letters **and** digits should be considered a delimiter. For example, if `digitDelimiter` is `true` then `a b3c*de` would be parsed into the tokens `a`, `b`, `c`, and `de`. If it is `false` then the same string would be parsed into the tokens `a`, `b3c`, and `de`.



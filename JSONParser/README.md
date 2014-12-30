JSONParser
=================
The main goal of the assignment is to give you experience parsing JSON files and retrieving data from JSON objects.

You  must implement the API provided in the `Configuration` and `InitializationException` classes exactly. If you do not pass all tests you will not receive full credit.

In this third homework assignment you will implement the portion of Project 1 that reads configuration information from a JSON-formatted file. You will be able to use your exact solution as part of Project 1.

See the Javadoc in the `Configuration` class for further explanation of how each method should behave. You will need to verify that the `Path` passed as input to the `Configuration` constructor refers to a valid path, that the contents of the file are valid JSON, and that the JSON has the two required keys -- `inputPath` and `digitDelimiter`. You will also verify that the value specified for `digitDelimiter` is a `true` or `false`. Finally, you will provide getter methods for both values.


ExceptionHandling
=================
The main goal of the assignment is to give you experience with exceptions.

You  must implement the API provided in the `ExceptionHandling` and `InvalidInputException` classes exactly. If you do not pass all tests you will not receive full credit.

In this second homework assignment you will write a simple program that provides several methods that take as input two strings, convert both from strings to integers using the `Integer.parseInt` method, and then use integer division to divide the first parameter by the second.

See the Javadoc in the `ExceptionHandler` class for further explanation of how each method should behave. In the first method you will catch all Runtime exceptions from within your method and print appropriate messages (exactly as specified!) to System.err. In the second method you will propagate any `NumberFormatException`. In the third method you will propagate any `ArithmeticException`. In the fourth method you will catch all exceptions and throw a custom exception of type `InvalidInputException` that you will implement. 


# SimpleCSharptoJavaCompiler
A simple C# to Java compiler which only has the functionality of Print Statements, If Statements, and While Loops. This compiler was built with the three important aspects of the compiler: Lexical Analyzer, Parser, and the Interpreter. 
# Lexical Analyzer
The Lexical Analyzer tokenizes the input file, and each token works as a label for what the corresponding value is associated with. Each parenthesis, curly brace, and operator must be tokenized for the parser to begin with creating statements regarding the tokens. The Lexical Analyzer is the easiest part of the program as it contains very little logic other than creating tokens for a language's syntax. 
# Parser
The Parser, as stated briefly in the last paragraph, is creating statements using those tokens that we created with the Lexical Analyzer. We start with the necessities such as what is the syntax for a base program in the specific language that we want to create this transpiler/interpreter in. For C#, the syntax is like Java as it contains a class with a class name, a public static void main function and finally the braces we encapsulate the program into. Once we have observed and implemented the tokens needed for a base program, we now need to worry about the logic contained within the program. We call this section the BLOCK of the code, the block simply contains a variety of statements as there would be for any program. The program simply acquires each statement, into a list of statements and then evaluates each statement to understand what function it is trying to implement. If the parser sees an IF token then it knows that the following statement should contain the following if statement syntax: if token, left_paren token, some Boolean expression followed by a right_paren token, followed by a left bracket, then our block which will contain our conditional check’s inner body, and followed by right bracket ending statement. Here is a visual representation of that:

if ( i < 5 ) {

// Insert Code Here

}

IF_TOK LEFT_PAREN_TOK ID_TOK LT_TOK LITERAL_INTEGER_TOK RIGHT_PAREN_TOK LEFT_BRACKET_TOK

//Block of Code Here

RIGHT_BRACKET_TOK

# Interpreter
Finally, we have our interpreter. The parser allowed us to understand what statements we were going to execute through and so now, we must execute these programs. Since we know what statements contain Boolean expressions, Arithmetic expressions, and conditional if and while loop statements thanks to the Parser, we can know put those into java like syntax. If a while statement is called, we must have a class that first checks that the expression and the corresponding block are not null. Once we have done that, we can set up a while loop with our Boolean expression to be evaluated, and if that check goes through then we will now execute those statements that are within the block of the while loop. Now we have an effective while loop that will run through, and change expressions needed within the loop. Values within the program need to be stored however which is the use of the Memory.java file is needed. With this file, we can store those ID_TOK values within an array of character values. The values stored in these arrays are then used within our print statements, and other arithmetic expressions to further change the values associated within the arrays. With this we can compute in large programs with vast amounts of arithmetic expressions. This is a brief introduction to the workings of this specific interpreter, but a better explanation would be implementing your very own test case files, and working with the logic first hand to see how exactly it operates.

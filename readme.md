# Hyperskill Academy project: Readability score

## Stage 1/4: Simplest estimation
Description
Ever wondered how to assess if the text is hard or easy to read? For a human, this task is pretty simple: you just read the text and feel if you're struggling or not. But how to teach a computer do that? In this project, you will write such a program.

Firstly, let's create a simple program. If a text contains more than 100 symbols (including spaces and punctuation), then it is considered hard to read. Otherwise, the text is considered easy to read. If a text contains exactly 100 symbols, it is still easy to read.

The input contains a single line of text. Output "HARD" if the text is hard to read and "EASY" if the text is easy to read.

Examples
The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.

Example 1: the text that has less than 100 symbols.

> This text is easy to read!
EASY
Example 2: the text that has more than 100 symbols.

> This text is hard to read. It contains a lot of sentences as well as a lot of words in each sentence.
HARD
Example 3: the text has lots of spaces and 104 symbols, making it hard to read.

> # T h i s  t e x t  h a s  a  l o t  o f  s p a c e s  a n d  p u n c t u a t i o n  m a r k s ! ! ! ! !
HARD
Example 4: the text has lots of spaces and only 93 symbols, making it easy to read.

> T h i s  t e x t  h a s  a  l o t  o f  s p a c e s  t o o  b u t  i s  e a s y  t o  r e a d
EASY

## Stage 2/4: Words and sentences
Description
However, a real text may be pretty long and still easy to read, right? There needs to be another approach. How about calculating the number of words in each sentence? Clearly, if each sentence of a text contains a lot of words, this text is hard to read.

Suppose that if the text contains sentences that on average have more than 10 words per sentence, this text is hard to read. Otherwise, this text is easy to read. Don't worry, we will consider more scientific ways in the next stages.

The input contains a single line of text. Output "HARD" if the text is hard to read and "EASY" if the text is easy to read.

For example, the first example contains two sentences with 6 and 10 words (numbers also count as words) so the average is 8, and this is less than 10. In the second example, there are also 2 sentences but with 6 and 16 words, so the average is 11 and this is more than 10. If the average is equal to 10, the text is still considered easy to read.

Don't forget that sentences can end with a full stop as well as with an exclamation mark and a question mark. But the last sentence can be with or without a punctuation mark at the end.

Examples
The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.

Example 1

> This text is simple to read! It has on average less than 10 words per sentence.
EASY
Example 2

> This text is hard to read. It contains a lot of sentences as well as a lot of words in each sentence
HARD


## Stage 3/4: Score!
Description
In this stage, you will program the Automated readability index (ARI). It was introduced in 1968 and a lot of research works rely on this. The index is calculated by the following formula:

score=4.71×characterswords+0.5×wordssentences−21.43

This article on ARI can give you more specifics on the application and age brackets.

Below you can see the table that specifies the age brackets.

readability score table

Also, your program should read a file instead of typing a text manually. You should pass the filename through the command line arguments.

The program should output the score itself and an approximate age needed to comprehend the text.

Use the appropriate rounding function to calculate the score as integer.

You should also print how many characters, words, and sentences the text has.

The number of characters is any visible symbol (so, in the real text it's everything except space, newline "\n" and tab "\t").

Notice, that the text can contain multiple lines, not just a single line like in the previous stages. You should analyze all the lines.

Examples
The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.

Example 1

> java Main in.txt
The text is:
Readability is the ease with which a reader can understand a written text. In natural language, the readability of text depends on its content and its presentation. Researchers have used various factors to measure readability. Readability is more than simply legibility, which is a measure of how easily a reader can distinguish individual letters or characters from each other. Higher readability eases reading effort and speed for any reader, but it is especially important for those who do not have high reading comprehension. In readers with poor reading comprehension, raising the readability level of a text from mediocre to good can make the difference between success and failure

Words: 108
Sentences: 6
Characters: 580
The score is: 12.86
This text should be understood by 17-18 year-olds.
Example 2

> java Main in.txt
The text is:
This is the page of the Simple English Wikipedia. A place where people work together to write encyclopedias in different languages. That includes children and adults who are learning English. There are 142,262 articles on the Simple English Wikipedia. All of the pages are free to use. They have all been published under both the Creative Commons License 3 and the GNU Free Documentation License. You can help here! You may change these pages and make new pages. Read the help pages and other good pages to learn how to write pages here. You may ask questions at Simple talk.

Words: 100
Sentences: 10
Characters: 476
The score is: 5.98
This text should be understood by 10-11 year-olds. 
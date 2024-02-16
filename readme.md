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

## Stage 4/4: More parameters
Description
In this stage, you should implement various other scientific approaches to calculate a readability score.

Take a look at different ages and corresponding scores in the table in ARI article on Wikipedia. This table is suitable for all the algorithms described in this stage. To calculate the age, use the upper bound of the range. For example, if the range is 12-13-year-olds then it's upper bound is 13-year-olds.

The first algorithm is Flesch–Kincaid readability tests. First, you need to create a method that calculates the number of syllables in a word. The formula is given below. You can find more information in the corresponding article on Wikipedia. You can use the second formula to calculate the index; it allows you to easily calculate the age of a person using the same table from the Automated Readability Index.

score=0.39∗wordssentences+11.8∗syllableswords−15.59
The second one is SMOG index. It stands for Simple Measure of Gobbledygook. To calculate it, you need to count the number of polysyllables, which is the number of words with more than 2 syllables. The formula is shown below. You can find out more in the Wikipedia article on SMOG. The article says that at least 30 sentences are required for this index to work properly. Don't pay attention to this, just keep it in mind when you use this index in real life. As in the previous example, the grade level is calculated here, so to get the age of a person you need to use the table from the first link.

score=1.043∗polysyllables∗30sentences−−−−−−−−−−−−−−−−−−−−√+3.1291
The next one is Coleman–Liau index. The formula is given below. For more information, read the article on Wikipedia. L is the average number of characters per 100 words and S is the average number of sentences per 100 words. Like all other indices, the output is a person's grade level. Like all other indices, the result is a minimum grade level required to understand this text.

score=0.0588∗L−0.296∗S−15.8
So, in this stage, you should program all three approaches. Don't forget about the Automated readability index! Also, there should be an option to choose all methods at the same time.

To count the number of syllables you should use letters a, e, i, o, u, y as vowels. In the short article on Vowels on Wikipedia you can see examples and intricacies with determining vowels in a word with 100% accuracy. So, let's use the following 4 rules:

1. Count the number of vowels in the word.
2. Do not count double-vowels (for example, "rain" has 2 vowels but only 1 syllable).
3. If the last letter in the word is 'e' do not count it as a vowel (for example, "side" has 1 syllable).
4. If at the end it turns out that the word contains 0 vowels, then consider this word as a 1-syllable one.

Example
The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.

> java Main in.txt
The text is:
This is the front page of the Simple English Wikipedia. Wikipedias are places where people work together to write encyclopedias in different languages. We use Simple English words and grammar here. The Simple English Wikipedia is for everyone! That includes children and adults who are learning English. There are 142,262 articles on the Simple English Wikipedia. All of the pages are free to use. They have all been published under both the Creative Commons License and the GNU Free Documentation License. You can help here! You may change these pages and make new pages. Read the help pages and other good pages to learn how to write pages here. If you need help, you may ask questions at Simple talk. Use Basic English vocabulary and shorter sentences. This allows people to understand normally complex terms or phrases.

Words: 137
Sentences: 14
Characters: 687
Syllables: 210
Polysyllables: 17
Enter the score you want to calculate (ARI, FK, SMOG, CL, all): all

Automated Readability Index: 7.08 (about 13-year-olds).
Flesch–Kincaid readability tests: 6.31 (about 12-year-olds).
Simple Measure of Gobbledygook: 9.42 (about 15-year-olds).
Coleman–Liau index: 10.66 (about 17-year-olds).

This text should be understood in average by 14.25-year-olds.
# Flashcards
Electronic Flashcards program for my  modules, written in java.

This pretty much works out of the box, you just need to create your own flashcards.
If you're creating flashcards for my modules then you'll need to make the following textfiles, in the same directory as the java file:
ComputerSystems.txt
IntroToAI.txt 
TheoryOfComputing.txt

## How to make a flashcard:
I have created a "markup language" type thing to help make the formating of flashcards easier.
You still save the flashcard questions and answers in the same textfile
Here is the current syntax:

<break>  -- moves on to the next card, this needs to be between every question and answer. acts as <br> in html
<line> -- puts test onto a new line. acts as "\n" in regex

## Here is an example:

This is a question<break>
This is the answer on the first line<line>this is the answer on the second line
<line>

This is the third line.
This is stil the third line
<line>
This it the 4th line

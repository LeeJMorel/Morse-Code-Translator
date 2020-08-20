CS211 SPRING 2020, Created: 6/17/20, Lee Janzen 

Morse Code translator is a basic tool that uses the Morse code tree to translate between english text and morse code.

You can run the program by running Morse Code.jar in you CMD or IDE and inputing any varety of custom text. 
Sample tests are also provided for user convience, as a way to navigate the program if you are unsure.


Write a program that encodes and decodes Morse code files using a binary tree. Morse code is a system that encodes the 26 English letters and 10 numeric digits into sequences of dots, dashes, and spaces. Your tree can store the encodings of each letter and number, going left for a dot and right for a dash. When your program reads a sequence of Morse code characters, it should traverse the tree in the appropriate direction for each character and output the letter or number it reaches at the end of each sequence.

Some thoughts on this project:
My first thought was to base the morse code response based on ASCII characters. 5 seconds into google to find how to translate morse code reveiled that a tree already existed and I was waaaayyyyyy off! I put together a data file with the morse translations in notepad to keep my code organized. I knew I wanted a graphic interface, I learned a lot about them during my spring break project, so next I built the GUI using swing. That was a fairly straight forward project, I minimally edited an already existing word counter interface to interact with my backend. At this point I began to break down the problem set. Binaray trees were a challenge for me to figure out, it's a data structure that seems non-intutive for me. I converted a Node to work with char rather than int, and added some get/set methods to provide myself with a lot of ways to traverse my tree. Then I went about trying to add the data correctly to my tree and printing it. I was stuck here for sometime! I built a little test client that worked soley with my MorseTree class while I figured it out, and like with most of my homework resolved it by talking it out with myself and friends. At this point, translation was easy. I added a decoder, then integrated the whole thing with my GUI. Encoder took slightly more time, I got lost on some of the recursive methods. They kept returning empty for me, and it took some time to resolve how to prevent that with an additional loop returning the results.

Referances used:
GUI built from this framework: https://www.javatpoint.com/word-count-in-java
Tree data built from: https://commons.wikimedia.org/wiki/File:Morse-code-tree.svg
Tree base was built from the IntSearchTree we had avalible from our exercises
How to add to a string in your method (decode and encode methods): https://www.javatpoint.com/string-concatenation-in-java
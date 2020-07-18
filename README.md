# Sudoku Sovler
<a href="OTP"><img src="https://live.staticflickr.com/2712/4058168141_ee18c9aafa.jpg" title="Logo" alt="Logo"></a>

## This program uses the backtracking algorithmic-technique to solve a user entered sudoku puzzle. 

### Input Structure

* User enters an integer **greater than or equal to 2** and **less than or equal 35** representing the size of the board.
* User follows with a single space, then enters another integer representing the width of the internal region.
* A block of numbers in base 36, following the size restraints, is then entered into the program. This represents a partially completed puzzle. Empty spaces are represented as a '0'.
* Finally, a lone zero indicates the end of input.
* After the user hits enter, the program outputs the fully solved sudoku puzzle!

**Example Input:**
```
12 4
0 0 3 4 A 8 0 0 0 2 0 0
0 0 0 1 0 0 0 0 0 0 0 4
0 8 0 0 0 4 3 0 5 0 0 0
0 0 0 0 8 0 0 9 0 0 0 A
8 0 0 C 7 0 4 0 9 6 0 3
A 1 9 3 B 6 0 0 0 0 C 0
0 3 0 0 0 0 6 4 2 A 5 B
1 0 4 2 0 A 0 5 3 0 0 8
C 0 0 0 3 0 0 7 0 0 0 0
0 0 0 5 0 7 9 0 0 0 A 0
3 0 0 0 0 0 0 0 6 0 0 0
0 0 C 0 0 0 2 8 4 B 0 0
0
```

#### Example Run:

![demo](http://g.recordit.co/AMQHsQPlKp.gif)

##### Output 

![img](https://i.imgur.com/018QKmF.png)

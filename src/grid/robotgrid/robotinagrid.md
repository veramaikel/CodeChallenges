# Robot in a Grid

Robot in a Grid: Imagine a robot sitting on the upper left corner of grid with r rows and c columns. 
The robot can only move in two directions, right and down, but certain cells are "off limits" such that the robot cannot step on them.
Design an algorithm to find a path for the robot from the top left to the bottom right.

## Symbology
```
R - Robot Start/Move
X - Robot Target
# - Blocked Square
. - Free Square 
```

## Example 1:
- Input:
   * beginning: 
   ```
     R # . . . . . .
     . . . . . . . .
     . . . . . . . .
     . . . . . . . .
     . # . . . . . .
     . . . . . . . .
     . . # # # # # #
     . . . . . . . X
  
    ```
    
- Output: 
   ```
     R # . . . . . .
     R . . . . . . .
     R . . . . . . .
     R . . . . . . .
     R # . . . . . .
     R R . . . . . .
     . R # # # # # #
     . R R R R R R R
  
    ```



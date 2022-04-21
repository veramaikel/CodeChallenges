# Build Order

You are given a list of projects and a list of dependencies (which is a list of pairs of projects, where the second project is dependent on the first project). 
All of a project’s dependencies must be built before the project is. Find a build order that will allow the projects to be built.

If there’s no valid order, return an error.

## Example 1:
- Input:
   * projects: ``` a, b, c, d, e, f ```
   * dependencies: ```(a, d), (f, b), (b, d), (f, a), (d, c)```
 
      ```
          f      e
         / \
        a   b
         \ /
          d
          |
          c 
      ```
    
- Output: ``` f, e, a, b, d, c ```


## Example 2:
- Input:
  * projects: ``` a, b, c, d, e, f, g, h ```
  * dependencies: ``` (c, a), (b, h), (a, e), (f, b), (d, g), (b, a), (f, c), (b, e), (f, a), (h, g), (e, g) ```
 
      ```
          f     d
         /|\    |
        c | b   |
         \|/|\  |
          a | h |
           \| | |
            e | |
             \|/
              g
      ```
    
- Output: ``` f, d, b, c, a, h, e, g ```


## Example 3:
- Input:
  * projects: ``` a, b, c, d, e, f, g, h ```
  * dependencies: ``` (c, a), (b, h), (a, e), (f, b), (d, g), (b, a), (f, c), (b, e), (f, a), (h, g), (e, c) ```
 
      ```
          f     d
         /|\    |
        c | b   |
        |\|/|\  |
        | a | h |
        |  \|  \|
        --->e   g
                
      ```
    
- Output: ERROR. Circular dependency issue between project ```c```, ```a```, and ```e```


    
   

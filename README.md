# Fractal Tree
Grows 4 fractal trees, the number under each tree indicates the amount of splits (into 2 branches) in the tree. 
<img src="https://github.com/llisaeva/FractalTree/blob/master/demo_img/fractal-tree.gif" align ="center" alt="animated" width="600"/>  

## How it Works
__Logistic equation used to generate the tree growth:__  
<img src="https://github.com/llisaeva/FractalTree/blob/master/demo_img/tree-function.JPG" align ="center" width="600"/>  
__On each split:__
- left branch: -25% length, rotates 30°
- right branch: -33% length, rotates 50°


This was an exercise from the book [Introduction to Programming with Java](https://www.mheducation.com/highered/product/introduction-programming-java-problem-solving-approach-dean-dean/M9780073376066.html).  

## Tools Used
- [Java 14](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Gradle Build Tool](https://gradle.org/)
- [Eclipse IDE](https://www.eclipse.org/eclipseide/)

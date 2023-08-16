## Table of Contents
1. [Objective](#objective)
2. [Use](#use)
    * [Input Files](#input-files)
3. [Additional Considerations](#additional-considerations)


## Objective

The objective of this project utilize linked lists to develop a simple, but useful application. This was completed in 2021 as an assignment.

Being that it was around the time to schedule my classes for the next semester, I figured what better do I have to do than make an app to help with the mental slog of scheduling classes.

- _Note_ : The imported from Eclipse 🤢 to a much, much, much, much better IDE; Comments might be a bit wonky.


## Use

Requires Java. Tested `openjdk 17.0.8`.

### Input Files

The app requires the use of an input text file. The expected format is 
`course_name1 <d><d><d><24h_time>`. For example:

```
CSE2010 MWF1200 TR1400 MWF1100
COM1101 MWF0900 MWF1000 MWF1100
```

_See more examples in `samples/input`_

Example compilation & run :

```bash
cd src
javac App.java
java App ../samples/input/One.txt

---Course Schedule---
CSE4301 MWF0900
MTH2001 MWF1500
COM2223 MWF1100

---Courses With a Time Conflict---
PHY1001 MWF1500 
```

Don't degrade yourself by using Eclipse; [here's a tutorial](https://code.visualstudio.com/docs/java/java-tutorial) on how to setup VS Code for Java. Basic, but at least you'll be able to sleep at night with dignity and self-respect.

## Additional Considerations

This project was not meant to be used casually. It doesn't take multiple, common scenarios in to account. 

For example, there is no way to specify the duration of a course.

If I was to recreate the app, I would include more robust functionality to make the program ideal for casual use. A somewhat similar mockup of an updated version can be found in [the sample recreation](SampleRecreation.ipynb).

If used as "inspiration," please link back to this repo.

Thanks,

\- Kay


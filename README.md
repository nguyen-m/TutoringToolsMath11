# TutoringToolsMath11

Current version:
A worksheet generator for two major topics in Pure Math 20 that students often struggle with: Factoring polynomials and Solving Quadratic Equations.
Written in Scala.

## 1. Polynomial Factorization
Generate factorization practice questions with answers. The contents will be in the source folder, Factoring-Questions.txt and Factoring-Answers.txt
- User input: "Factoring", and amount of question in worksheet.
- Question format: **x^2 + bx + c**. Sample question: (i.e. x^2 - 8*x + 15)
- Answers format: **(x+A)(x+B)**. Sample Solution: (x - 5)(x - 3)

## 2. Quadratic Functions
Generate practice questions in the form of Quadratic equations. Answers will include the Vertex, Real x-Intercepts, Domain and Range. The content will be written in Quadratic-Questions.txt and Quadratic-Answers.txt.
- User input: "Quadratic", and amount of questions in worksheet.

[Quadratic Functions](https://en.wikipedia.org/wiki/Quadratic_function) are explored extensively in Grade 11 Math curriculum. In the majority of questions, students need to work with either the **General Form** or the **Vertex Form** of a quadratic function.

Calculations of the **Vertex, x/y-intercepts, Axis if symmetry, Domain and Range** are often required.

### 2.1. General Form
A quadratic function can be written in general form: **Ax^2 + Bx + C**.

In this form, it is easy to see that the **y-intercept** equals to **+C**. The values of **x-intercepts** (if they exist), are not so apparent. The determination of the x-intercepts based on the general form of a quadratic equation will be discussed in section **2.4 Solving Quadratic Equations**.

### 2.2. Vertex Form
The vertex form of a quadratic function is: **A(x - i)^2 + j**. As the name suggests, the vertex of a quadratic function in vertex form can be readily obtained from the given parameters. For the generic function above, the Vertex is at the point (i, j).
It is important to note that if the vertex of a parabolla is known, its axis of symmetry can be readily obtained from the x value of the vertex. For the general case above, the axis of symmetry is the vertical line defined by y = i.
### 2.3. Domain and Range
- Domain: The domain of a quadratic equation is the set of all real values of x that result in corresponding real values of y. Since the graph of a quadratic function is a parabolla opening up or down, and there is no limiting condition for x (in the scope of this course), x can be any real number, or x ∈ R.

- Range: The range of a quadratic equation is the set of all real values of y that can be obtained. Depending on the parabolla's direction of opening, the range is defined by all real values from the vertex to positive or negative infinity.



# TutoringToolsMath11

Current version:
A worksheet generator for two major topics in Pure Math 20 that students often struggle with: Factoring polynomials and Solving Quadratic Equations.
Written in Scala.


## 1. Factoring Polynomial
Generate factoring practice questions with answers. The contents will be written to Factoring-Questions.txt and Factoring-Answers.txt
- User input: "Factoring", and amount of question in worksheet.
- Question format: **x^2 + bx + c**. Sample question: x^2 - 8*x + 15
- Answer format: **(x+A)(x+B)**. Sample Solution: (x - 5)(x - 3)

## 2. Solving Quadratic Functions with Quadratic Formula
Generate practice questions in the form of quadratic equations with randomly generated parameters. Answers will include the Vertex, Real or Complex roots, Axis of symmetry, Domain and Range. The content will be written to Quadratic-Questions.txt and Quadratic-Answers.txt.
- User input: "Quadratic", and amount of questions in worksheet.

[Quadratic Functions](https://en.wikipedia.org/wiki/Quadratic_function) are explored extensively in Grade 11 Math curriculum. In the majority of questions, students need to work with either the **General Form** or the **Vertex Form** of a quadratic function.

Calculations of the **Vertex, x-intercepts (or roots), Axis of symmetry, Domain and Range** are often required.

### 2.1. General Form
A quadratic equation can be written in general form: **Ax^2 + Bx + C = 0**.

In this form, it is easy to see that the **y-intercept** equals to **+C**. The values of **x-intercepts** (or roots), are not so apparent. Thus, the **Quadratic Formula** will be used to calculate the roots.

### 2.2. Vertex Form
The vertex form of a quadratic function is: **A(x - Vx)^2 + Vy**. As the name suggests, the vertex of a quadratic function in vertex form can be readily obtained from the given parameters. For the generic case shown, the Vertex is at the point (Vx, Vy).
It is important to note that if the vertex of a parabola is known, its axis of symmetry can be readily obtained as Axis of symmetry: y = Vx.
### 2.3. Domain and Range
The domain of a quadratic equation is the set of all real values of x that result in corresponding real values of y. Since the graph of a quadratic function is a parabola opening up or down, and there is no special restricting condition for x in the scope of this course, x can be any real number, or **x ∈ R**.

The range of a quadratic equation is the set of all real values of y that can be obtained from real values of x. Depending on the parabola's direction of opening, the range is defined by all real values from the vertex to positive or negative infinity.


---

@snap[midpoint span-80 text-20]
A Gentle Introduction to Scala and FP
@snapend

---

@snap[north-west span-100 fixed-v-header]
### Hi, I'm Anton!
@snapend

@snap[west span-45]
@ul[list-spaced-bullets](false)
- Functional programmer
- Scala enthusiast
- Applications engineer at Rakuten
@ulend
@snapend

@snap[east text-center span-45]
<div class="left-vv">
![avatar](assets/images/avatar.jpg)


@css[text-12 link-color](@a7emenov)

Find me on [Twitter](https://twitter.com/a7emenov), [Telegram](https://t.me/a7emenov) and [Github](https://github.com/a7emenov)
</div>
@snapend

---

@snap[north-west span-100 fixed-v-header]
### Agenda
@snapend

@snap[west span-100 fixed-v-content]
@ul[list-spaced-bullets](false)
- Introduce Scala as a language
- Give examples of universal FP constructs
- Show benefits of those constructs
- Compare Scala to other languages
@ulend
@snapend

---

@snap[west span-50]
![](assets/images/scala-logo.png)
@snapend

@snap[east span-50 text-center]
<div class="left-vvvv">
### What is Scala as a language?
</div>
@snapend

---

@snap[west span-40 text-center]
@img[](assets/images/scala-structure.png)
@snapend

@snap[east span-55 text-center text-12]
Scala combines object-oriented and functional programming in one @css[highlight](concise), @css[highlight](high-level) language.
@snapend

---

@snap[north-west span-100 fixed-v-header]
### What lies at the core of FP?
@snapend

@snap[west span-50 fixed-v-content]
@ul[list-spaced-bullets](true)
- Absence of side-effects in computations
- Function composition
- Immutable data
- Dark magic
@ulend
@snapend

@snap[east span-30 text-center fragment text-50]
<div class="left-vvv">
@css[](?)
</div>
@snapend


--- 

@snap[north-west span-100 fixed-v-header]
### What lies at the core of FP?
@snapend

@snap[west span-50 fixed-v-content]
@ul[list-spaced-bullets](false)
- Absence of side-effects in computations
- Function composition
- Immutable data
- Dark magic
@ulend
@snapend

@snap[east span-40 text-center text-18 highlight]
<div class="left-vv">
All of it
</div>
@snapend

--- 

@snap[midpoint text-center span-100 text-18]
Functional programming is a <br> @css[highlight](way of solving problems) which <br> centers around combining <br> @css[highlight](side-effect-free constructs) in a <br> @css[highlight](declarative manner)
@snapend

---

@snap[north-west fixed-v-header]
### Declarative vs. imperative
@snapend

@snap[west fixed-v-content text-left span-50]
#### Imperative
```java zoom-14
for (int i = 1; i <= 5; i++) {
  int temp = i * 2;
  if (temp < 6) {
    System.out.println(temp);
  }
}
```
@snapend

@snap[east fixed-v-content text-left span-50]
#### Declarative
```scala zoom-14
(1 to 5)
  .map(_ * 2)
  .filter(_ < 6)
  .foreach(println)
```
@snapend

---?color=linear-gradient(90deg, white 45%, #dddddd 45%)

@snap[west text-center span-40]
### Deep dive
FP & Scala
@snapend

@snap[east text-left span-50]
@ul[list-spaced-bullets](false)
- Immutability
- Pure functions
- Referential transparency
- Algebraic data types
- Pattern matching
- Recursion
@ulend
@snapend

+++

@snap[north-west fixed-v-header]
### Value mutation
@snapend

@snap[west fixed-v-content text-left span-50]
#### Variables
@ul[list-spaced-bullets](false)
- Can be changed anytime
- Can be changed from any place that has a reference
- Can lead to unintentional shared mutable state
@ulend
@snapend

@snap[east fixed-v-content text-left span-45]
#### Immutable values
@ul[list-spaced-bullets](false)
- Can't be changed
- Create new values instead of changing the old ones
- No mutable state
@ulend
@snapend

+++

@snap[north-west fixed-v-header]
### Value mutation
@snapend


@snap[west fixed-v-content text-left span-35]
#### Variables
@img[force-center height-40](assets/images/hulk-2.png)
@snapend

@snap[east fixed-v-content text-left span-45]
#### Immutable values
<div class="left-vv">
@img[force-center height-40](assets/images/bruce-banner.png)
</div>
@snapend

+++

@snap[north-west fixed-v-header]
### Immutable values
@snapend

@snap[west fixed-v-content text-left span-45]
#### Benefits
@ul[list-spaced-bullets](false)
- Reduce concurrency issues
- No shared mutable state
- Easier local reasoning
@ulend
@snapend

@snap[east fixed-v-content text-left span-50]
#### Drawbacks
@ul[list-spaced-bullets](false)
- Extra memory allocations
@ulend
@snapend

+++

@snap[north-west fixed-v-header span-100]
### Pure functions
@snapend

@snap[west fixed-v-content text-left span-100]

**Side-effect free** - everything that a function does can be observed in its return value:

<div style="height: 2vh;"></div>

@ul[list-spaced-bullets](false)
- **Total** - return values for every possible input
- **Deterministic** - given same inputs, return same outputs
- **Locally scoped** - no effect on the state outside of the function's scope
@ulend
@snapend

+++

@snap[north-west fixed-v-header span-100]
### Referential transparency
@snapend

@snap[midpoint span-75 text-18]
All calls to a function can be substituted with its return value
@snapend

+++

@snap[north-west fixed-v-header]
### Referential transparency
@snapend

@snap[west fixed-v-content text-left span-50]
#### Not transparent
```scala zoom-14
def getInt(l: Int, r: Int): Int = 
  Random.between(l, r)

def increment(x: Int): Int = {
  val res = x + 1
  destroyTheWorld()
  res
}
```
@snapend

@snap[east fragment fixed-v-content text-left span-45]
#### Transparent
```scala zoom-14
def fact(n: Int): Int = {
  var res = 1
  var i = 1
  while (i <= n) {
    res = res * i
    i = i + 1
  }
  res
}
```
@snapend

+++

@snap[north-west fixed-v-header]
### Business value with pure functions
@snapend

@snap[midpoint span-80 text-18]
Can we create a useful program without any <br> side-effects?
@snapend

+++

@snap[north-west fixed-v-header]
### Business value with pure functions
@snapend

@snap[west fixed-v-content span-75]
@ul[list-spaced-bullets](false)
- @css[highlight](Describe) side-effecting computations instead of instantly running them
- Combine all side-effects to produce a single description
- Run the resulting computation in the `main` method
@ulend
@snapend

+++

@snap[north-west fixed-v-header]
### Business value with pure functions
@snapend

@snap[midpoint span-60]

<div style="height: 4vh;"></div>


```scala zoom-50 text-center
IO[A]
```

<div style="height: 2vh;"></div>

A description of a computation that will produce `A`.
@snapend

+++

@snap[north-west fixed-v-header]
### Business value with pure functions
@snapend

@code[scala fixed-v-content code-reveal-fast](assets/code/business_value.scala)
@snap[west span-100 text-08]
@[1,3, zoom-16]()
@[9, zoom-16]()
@[5, zoom-16]()
@[7-10, zoom-16]()
@[7-12, zoom-16]()
@snapend

+++ 

@snap[north-west fixed-v-header]
### Pure functions
@snapend


@snap[west fixed-v-content text-left span-45]
#### Benefits
@ul[list-spaced-bullets](false)
- Ultimate local reasoning
- Parallelizable execution
- Easy testing
@ulend
@snapend

@snap[east fixed-v-content text-left span-50]
#### Drawbacks
@ul[list-spaced-bullets](false)
- Extra object allocations
- Require an effect system or a library to operate mutable state
@ulend
@snapend

+++ 

@snap[north-west fixed-v-header]
### Algebraic data types
@snapend

@snap[west fixed-v-content text-left span-100]
@ul[list-spaced-bullets](false)
- **Product types** - define how to create a value <br>(“has a field” relationship)
- **Sum types** - define the range of values <br> (“is one of” relationship)
@ulend

@snap[text-center span-100 text-16]
Product types + Sum types = <br> Algebraic data types
@snapend

@snapend

+++

@snap[north-west fixed-v-header]
### Product types
@snapend

@snap[west fixed-v-content text-left span-45]
#### Traditional classes
```java zoom-10
public class Person {
  // Which is the primary constructor?
  // Are the constructors related?
  public Person(Age age, 
                Year birthYear) 
    { /* ... */ }

  public Person(Year currentYear,
                Age age) 
    { /* ... */ }

  public Person(Year currentYear, 
                Year birthYear) 
    { /* ... */ }
}
```
@snapend


@snap[east fragment fixed-v-content text-left span-50]
#### Product types
```scala zoom-10
// Primary constructor defines the product
case class Person(age: Age,
                  birthYear: Year) {

  // Supplementary constructors 
  // must use the primary constructor
  def this(currentYear: Year, age: Age) 
    { this(age, currentYear - age) }
  

  def this(currentYear: Year, birthYear: Year) 
    { this(currentYear - birthYear, birthYear) }
}
```
@snapend

+++

@snap[north-west fixed-v-header]
### Sum types
@snapend

@snap[west fixed-v-content text-left span-45]
#### Traditional interfaces
```java zoom-10
public interface User 
  { /* Common methods */ }

public class Client implements User 
  { /* Client-specific methods */ }

public class Admin implements User 
  { /* Admin-specific methods */ }

void process(User user) {
  // How can this function reason about all
  // possible implementations of User?
}
```
@snapend


@snap[east fragment fixed-v-content text-left span-50]
#### Sum types
```scala zoom-10
// "Sealed" allows the compiler to find
// all descendants of User
sealed trait User 
  { /* Common methods */ }

case class Client extends User 
  { /* Client-specific methods */ }

case class Admin extends User 
  { /* Admin-specific methods */ }

def process(user: User): IO[Unit] = {
  // The function now has knowledge that 
  // there are only 2 options for "user"
}
```
@snapend

+++

@snap[north-west fixed-v-header]
### Pattern matching
@snapend

@snap[west fixed-v-content text-left span-45]
#### Data construction
```scala zoom-10
sealed trait User

case class Client(email: String
                  role: String) 
  extends User 

case class Admin(name: String,
                 scopes: List[String]) 
  extends User 

val client: User = 
  Client("test@email.com", "manager")

val admin: User = 
  Admin("Jane", List("emails", "orders"))
```
@snapend


@snap[east fixed-v-content text-left span-50]
#### Data deconstruction
```scala zoom-10
def process(u: User): IO[Unit] = u match {
  case Client(email, "manager") =>
    logManager(email)

  case Client(email, _) =>
    logNonManager(email)

  case Admin(name, Nil) =>
    logAdmin(name, "No scopes")

  case Admin(name, List("emails")) =>
    logAdmin(name, "Only 'emails' scope")

  case Admin(name, scopes) =>
    logAdmin(name, "Has 'orders' scope")
}
```
@snapend

+++

@snap[north-west fixed-v-header]
### ADTs and pattern matching
@snapend

@snap[west fixed-v-content text-left span-45]
#### Benefits
@ul[list-spaced-bullets](false)
- Enhanced code readability
- Reduced scope of thinking
- Compile-time checks
@ulend
@snapend


@snap[east fixed-v-content text-left span-50]
#### Drawbacks
@ul[list-spaced-bullets](false)
- Extra memory allocations
@ulend
@snapend

+++

@snap[north-west fixed-v-header]
### Recursion
@snapend

@snap[west fixed-v-content text-left span-45]
@ul[list-spaced-bullets](false)
- Declarative
- Native mapping to many real-world problems
- Can be as efficient as a loop*
@ulend
@snapend


@snap[east fixed-v-content text-left span-50]
```scala zoom-10
import scala.annotation.tailrec

@tailrec
def foldLeft\[R\](list: List[Int])
               (acc: R)
               (f: (R, Int) => R): R = 
  list match {
    case Nil => 
      acc
    case head :: tail => 
      foldLeft(tail)(f(acc, head))(f)
  }

// "12345"
foldLeft(List(1, 2, 3, 4, 5))(acc = "") { 
  (acc, num) => acc + num.toString 
} 
```
@snapend

+++

@snap[north-west fixed-v-header]
### FP in Scala - covered points
@snapend

@snap[west fixed-v-content text-left span-100]
@ul[list-spaced-bullets](false)
- Immutability
- Pure functions
- Referential transparency
- Algebraic data types
- Pattern matching
- Recursion
@ulend
@snapend


---?color=linear-gradient(90deg, white 45%, #dddddd 45%)

@snap[west text-center span-40]
### Scala <br> language <br> features
@snapend

@snap[east text-left span-50]
@ul[list-spaced-bullets](false)
- For-comprehensions
- Higher-kinded types
- Syntax extensions
- Macros
- Implicit values
@ulend
@snapend

+++

@snap[north-west fixed-v-header]
### For comprehensions
@snapend

@snap[west fixed-v-content text-left span-100]
```scala zoom-14
def getProfile(userName: String): Option[Profile] = ???

def getComments(profile: Profile): Option[List[Comment]] = ???

def getBonus(profile: Profile): Option[Int] = ???

val updatedComments = for {
  profile  <- getUserProfile("Jack")
  comments <- getComments(profile)
  bonus    <- getBonus(profile)
} yield comments.take(10)
                .map(_.increaseRating(bonus))
```
@snapend

+++

@snap[north-west fixed-v-header]
### For comprehensions
@snapend

@snap[west fixed-v-content text-left span-85]
@ul[list-spaced-bullets](false)
- Define coherent syntax for sequential composition
- Syntactic sugar for every type with `map`, `flatMap` and `withFilter` methods
- Can be used with any type supplying these methods
- Take advantage of pattern matching
@ulend
@snapend

+++

@snap[north-west fixed-v-header]
### Higher-kinded types
@snapend

@snap[west fixed-v-content text-left span-45]
@ul[list-spaced-bullets](false)
- **Simple types:** <br> Int, String, User
- **Unary type constructors:** <br> List[A], Future[A]
- **Binary type constructors:** <br> Either[A, B], Tuple[A, B]
@ulend
@snapend


@snap[east fixed-v-content text-left span-50]
**Higher-kinded types**:
```scala zoom-12
trait Transformer[L[_]] {
  def run\[A, B\](l: L[A])
               (f: A => B): L[B]
}

val listT = new Transformer[List] {
  def run\[A, B\](l: List[A])
               (f: A => B): List[B] =
    l.map(f)
}

// 0, 1, 2
listT.run(List(1, 2, 3))(_ - 1)
```
@snapend

+++

@snap[north-west fixed-v-header]
### Macros
@snapend

@snap[west fixed-v-content text-left span-45]
@ul[list-spaced-bullets](false)
- Eliminate boilerplate code
- Provide implementations at compile time
@ulend
@snapend


@snap[east fixed-v-content text-left span-50]
```scala zoom-12
import io.circe._
import io.circe.generic.semiauto._

case class Foo(a: Int, b: String)

val fooEncoder: Encoder[Foo] =
  deriveEncoder

fooEncoder.encode(Foo(1, "b"))
```
@snapend

+++

@snap[north-west fixed-v-header]
### Implicit values
@snapend

@snap[west fixed-v-content text-left span-45]
@ul[list-spaced-bullets](false)
- Provide automatic value forwarding
- Resolved at compile-time
- Can be created by the compiler
@ulend
@snapend


@snap[east fixed-v-content text-left span-50]
```scala zoom-12 wrap
case class Foo(a: Int, b: String)

object Foo {
  implicit val e: Encoder[Foo] =
    deriveEncoder
}

def process(foos: List[Json])
  (implicit e: Encoder[Foo]) = 
    foos.map(d.decodeJson)

/// Other part of the program:
process(List(Foo(1, "a")))
```
@snapend

+++

@snap[north-west fixed-v-header]
### Syntax extensions
@snapend

@snap[west fixed-v-content text-left span-45]
@ul[list-spaced-bullets](false)
- Allow to create ad-hoc methods for code reuse and readability
- Can be used for types imported from other projects/libraries
@ulend
@snapend


@snap[east fixed-v-content text-left span-50]
```scala zoom-12
implicit class StringSyntax
               (s: String) {
  def asciiLetters: String = 
    s.filter(c => c < 256 && c.isLetter)
}

// "123"
"1ab23c".asciiLett

```
@snapend

+++

@snap[north-west fixed-v-header]
### Scala language - covered points
@snapend

@snap[west fixed-v-content text-left span-100]
@ul[list-spaced-bullets](false)
- For-comprehensions
- Higher-kinded types
- Macros
- Implicit values
- Syntax extensions
@ulend
@snapend

---?color=linear-gradient(90deg, white 45%, #dddddd 45%)

@snap[west text-center span-40]
### Scala in <br> numbers
@snapend

@snap[east text-left span-50]
@ul[list-spaced-bullets](false)
- Development and adoption rates
- Effect on productivity
- Performance
@ulend
@snapend

+++

@snap[north-west fixed-v-header]
### Scala adoption rates
@snapend

@snap[west fixed-v-content text-left text-08 span-45]
@ul[list-spaced-bullets](false)
- Maintained intense release schedule for over 15 years
- Development of the language is supported by the European government and enterprise investors<sup>[1]</sup>
- Almost as popular as Kotlin for backend development<sup>[2]</sup> and is 15% more widespread in big companies<sup>[3]</sup>
@ulend
@snapend


@snap[east fixed-v-content span-50]
<canvas data-chart="line">
<!--
{
  "data": {
    "labels": [2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018],
    "datasets": [
      {
        "data": [1, 4, 2, 4, 3, 2, 2, 2, 3, 3, 3, 2, 2, 3, 4, 4],
        "label": "Scala",
        "borderColor": "#f64646",
        "backgroundColor": "#f64646",
        "fill": false,
        "lineTension": 0
       },
       {
        "data": [0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 2],
        "label": "Java",
        "borderColor": "#f89820",
        "backgroundColor": "#f89820",
        "fill": false,
        "lineTension": 0
       }
    ]
  },

  "options": {
    "title": {
      "display": true,
      "text": "Scala/Java releases",
      "fontSize": 32,
      "fontColor": "black",
      "fontFamily": "'Montserrat', sans-serif"
    },
    "animation": false,
    "responsive": true,
     "legend": {
       "position": "bottom",
       "labels": {
        "fontColor": "black"
       }
     },
     "scales": {
       "xAxes": [{
        "ticks": {
           "fontColor": "black"
         },
         "gridLines": {
          "display": false
        }
       }],
      "yAxes": [{
        "scaleLabel": {
          "display": true,
          "labelString": "language releases",
          "fontSize": 18,
          "fontColor": "black"
        },
        "ticks": {
          "stepSize": 1,
          "max": 5,
          "fontColor": "black"
        }
      }]
    }
  }
}
-->
</canvas>
@snapend

@snap[south-east]
@ol[text-08](false)
1. [bit.ly/2Xr3bnH](https://bit.ly/2Xr3bnH) <br> [bit.ly/2rPlUgW](https://bit.ly/2rPlUgW)
1. [api.github.com](https://api.github.com/search/repositories)
1. [stackshare.io/scala](https://stackshare.io/scala)
@olend
@snapend

+++ 

@snap[north-west fixed-v-header]
### Scala adoption rates
@snapend

@snap[west fixed-v-content text-left span-75]
@ul[list-spaced-bullets](false)
- StackOverflow survey of 2019 claims that almost 60% of respondents have tried Scala and are interested in working with it
- Approximately 4% of developers are use Scala as their main language at work
@ulend
@snapend

@snap[south-east text-08]
Source: [insights.stackoverflow.com/survey/2019](https://insights.stackoverflow.com/survey/2019)
@olend
@snapend

+++

@snap[north-west fixed-v-header]
### Scala and productivity
@snapend

@snap[west height-50 text-center span-50]
<canvas data-chart="pie">
<!--
{
  "data": {
    "datasets": [
      {
        "data": [37, 18, 383],
        "backgroundColor": [ "#ff0000", "#ff9900", "#6aa84f" ]
       }
    ],
    "labels": [
      "Decreased",
      "Stayed the same",
      "Increased"
    ]
  },
  "options": {
    "title": {
      "display": true,
      "text": "Productivity change",
      "fontSize": 32,
      "fontColor": "black",
      "fontFamily": "'Montserrat', sans-serif"
    },
    "animation": false,
    "responsive": true,
   
    "maintainAspectRatio": false,
     "legend": {
       "position": "bottom",
       "labels": {
        "fontColor": "black"
       }
     }
  }
}
-->
</canvas>
@snapend


@snap[east height-50 text-center span-50]
<canvas data-chart="pie">
<!--
{
  "data": {
    "datasets": [
      {
        "data": [40, 32, 292],
        "backgroundColor": [ "#ff0000", "#ff9900", "#6aa84f" ]
       }
    ],
    "labels": [
      "Decreased",
      "Stayed the same",
      "Increased"
    ]
  },
  "options": {
    "title": {
      "display": true,
      "text": "Time-to-market change",
      "fontSize": 32,
      "fontColor": "black",
      "fontFamily": "'Montserrat', sans-serif"
    },
    "animation": false,
    "responsive": true,
    "maintainAspectRatio": false,
     "legend": {
       "position": "bottom",
       "labels": {
        "fontColor": "black"
       }
     }
  }
}
-->
</canvas>
@snapend

@snap[south-east text-08]
Source: [bit.ly/2qombqM](https://bit.ly/2qombqM)
@snapend

+++

@snap[midpoint text-center span-90 text-12]
Scala’s functional programming style allows @css[highlight](writing 2 times less code)<sup>[1]</sup>

<div style="height: 2vh;"></div>

@css[highlight](Reading) Scala code is @css[highlight](2 times faster) on average<sup>[1]</sup>

<div style="height: 2vh;"></div>

Research data<sup>[2]</sup> shows that Scala projects need @css[highlight](~30% less bug fixes)
@snapend

@snap[south-east]
@ol[text-08](false)
1. [bit.ly/37eiWTH](https://bit.ly/37eiWTH)
1. [arxiv.org/pdf/1901.10220.pdf](https://arxiv.org/pdf/1901.10220.pdf )
@olend
@snapend

+++

@snap[north-west fixed-v-header]
### Scala's performance
@snapend

@snap[west fixed-v-content text-left span-45 text-08]
@ul[list-spaced-bullets](false)
- Uses JVM as the main runtime platform
- Can be compiled to a native binary
- Up to 35% performance increase with GraalVM<sup>[1]</sup>
- Utilizes incremental compilation for only a few seconds delay per build
@ulend
@snapend

@snap[east fixed-v-content span-50]
<canvas data-chart="bar">
<!--
{
  "data": {
    "datasets": [
      {
        "data": [2, 2, 10, 8],
        "borderColor": "#f64646",
        "backgroundColor": "#f64646",
        "label": "Scala"
       },
       {
        "data": [0, 1, 6, 83],
        "borderColor": "#f89820",
        "backgroundColor": "#f89820",
        "label": "Java"
       }
    ],
    "labels": [
      "Filter + count",
      "Group",
      "Sort + collect",
      "Filter + sort + map + collect"
    ]
  },
  "options": {
    "title": {
      "display": true,
      "text": "Collection operations speed comparison [2]",
      "fontSize": 28,
      "fontColor": "black",
      "fontFamily": "'Montserrat', sans-serif"
    },
    "scales": {
       "xAxes": [{
        "ticks": {
           "fontColor": "black",
           "autoSkip": false,  
           "maxRotation": 0,
          "minRotation": 0
         },
         "gridLines": {
          "display": false
        }
       }],
      "yAxes": [{
        "scaleLabel": {
          "display": true,
          "labelString": "s/mln ops",
          "fontSize": 18,
          "fontColor": "black"
        },
        "ticks": {
          "max": 90,
          "fontColor": "black"
        }
      }]
    },
    "animation": false,
    "responsive": true,
     "legend": {
       "position": "bottom",
       "labels": {
        "fontColor": "black",
        "fontFamily": "'Montserrat-medium'"
       }
     }
  }
}
-->
</canvas>
@snapend

@snap[south-east]
@ol[text-08](false)
1. [graalvm.org/scala](https://www.graalvm.org/scala)
1. [bit.ly/330Ugue](https://bit.ly/330Ugue)
@olend
@snapend

+++

@snap[west fixed-v-header text-center span-100]
### Scala as a language
@snapend

@snap[west fixed-v-content text-left span-100 text-14]
@ul[list-spaced-bullets](false)
- Rapidly developed
- Adopted by many big companies
- Offers significant productivity benefits
- Keeps reasonable performance
@ulend

@snapend

---?color=linear-gradient(90deg, white 45%, #dddddd 45%)

@snap[west text-center span-40]
### Scala in real world
@snapend

@snap[east text-left span-50]
@ul[list-spaced-bullets](false)
- Areas of application
- Scala vs. Java & Kotlin
- Scala vs. Python
- Scala vs. Golang
- Future prospects
@ulend
@snapend

+++

@snap[north-west fixed-v-header]
### Areas of application
@snapend

@snap[west fixed-v-content text-center span-42]
@box[bg-soft-green rounded text-white](Data pipelines)

<br>

@box[bg-soft-green rounded text-white](Resilient applications)

<br>

@box[bg-soft-green rounded text-white](Distributed systems)
@snapend


@snap[east fixed-v-content text-center span-42]
<div class="left-vv">
@box[bg-soft-red rounded text-white](Small or simple systems)

<br>

@box[bg-soft-red rounded text-white](Low-level manipulation)

<br>

@box[bg-soft-red rounded text-white](UI-centered applications)
</div>
@snapend

+++

@snap[north-west fixed-v-header]
### Scala vs. Java & Kotlin
@snapend

@snap[west fixed-v-content text-09 text-left span-45]
#### Java & Kotlin
@ul[list-spaced-bullets](false)
- Vast number of libraries for different needs
- Reasonable performance for most tasks
- OOP approach
- JVM as runtime platform
@ulend
@snapend


@snap[east fixed-v-content text-09 text-left span-50]
#### Scala
@ul[list-spaced-bullets](false)
- Fully compatible with Java and Kotlin libraries
- Performance competitive with Java/Kotlin
- Allows for both FP and OOP
- Target JVM, browser and native environments
@ulend
@snapend


+++

@snap[north-west fixed-v-header]
### Scala vs. Python
@snapend

@snap[west fixed-v-content text-09 text-left span-45]
#### Python
@ul[list-spaced-bullets](false)
- Ad-hoc Spark & Hadoop integration
- Easy to prototype ideas
- Great number of math and visualisation libraries
- Relatively slow on big volumes on data
@ulend
@snapend


@snap[east fixed-v-content text-09 text-left span-50]
#### Scala
@ul[list-spaced-bullets](false)
- Native Spark & Hadoop integration
- Compile-time verification
- Mainly ML-oriented libraries <br><br>
- Performs well on terabytes of data

@ulend
@snapend

+++

@snap[north-west fixed-v-header]
### Scala vs. Golang
@snapend

@snap[west fixed-v-content text-09 text-left span-45]
#### Golang
@ul[list-spaced-bullets](false)
- Fixed imperative style
- Blazing fast speed
- Concurrency primitives on the language level
@ulend
@snapend


@snap[east fixed-v-content text-09 text-left span-50]
#### Scala
@ul[list-spaced-bullets](false)
- Extensible declarative style
- Reasonable performance
- Libraries for scalability
@ulend
@snapend

+++

@snap[north-west fixed-v-header]
### Future prospects
@snapend

@snap[north text-16 span-85]
<div class="fixed-v-content">
Next major version of Scala is coming at the end of 2020. 

<div style="height: 4vh;"></div>

Take a look at:<br> [dotty.epfl.ch](https://dotty.epfl.ch)
</div>
@snapend

+++?image=assets/images/scala3.png&size=contain

---

@snap[west text-center span-45 text-18]
Thank you for your attention!
Any questions?
@snapend

@snap[east text-center span-45]
<div class="left-vv">
@css[text-14 link-color](@a7emenov)

Find me on [Twitter](https://twitter.com/a7emenov), [Telegram](https://t.me/a7emenov) and [Github](https://github.com/a7emenov)
</div>
@snapend
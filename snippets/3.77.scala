@ for(i <- Range(1, 101)){
    (i % 3, i % 5) match{
      case (0, 0) => println("FizzBuzz")
      case (0, _) => println("Fizz")
      case (_, 0) => println("Buzz")
      case _ => println(i)
    }
  }
1
2
Fizz
4
Buzz
...

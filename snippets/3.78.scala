@ for(i <- Range(1, 101)){
    (i % 3 == 0, i % 5 == 0) match{
      case (true, true) => println("FizzBuzz")
      case (true, false) => println("Fizz")
      case (false, true) => println("Buzz")
      case (false, false) => println(i)
    }
  }

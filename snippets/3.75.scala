@ def dayOfWeek(x: Int) = x match{
    case 1 => "Mon"
    case 2 => "Tue"
    case 3 => "Wed"
    case 4 => "Thu"
    case 5 => "Fri"
    case 6 => "Sat"
    case 7 => "Sun"
    case _ => "Unknown"
  }

@ dayOfWeek(1)
res161: String = "Mon"

@ dayOfWeek(7)
res162: String = "Sun"

@ dayOfWeek(-1)
res163: String = "Unknown"

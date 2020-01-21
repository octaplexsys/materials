@ def getDayMonthYear(s: String) = s match{
    case s"$day-$month-$year" => Some((day, month, year))
    case _ => None
  }

@ getDayMonthYear("9-8-1965")
res37: Option[(String, String, String)] = Some(("9", "8", "1965"))

@ getDayMonthYear("9-8")
res38: Option[(String, String, String)] = None

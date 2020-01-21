@ for(headline <- headlines) yield (headline.attr("title"), headline.attr("href"))
res15: collection.mutable.Buffer[(String, String)] = ArrayBuffer(
  ("Bek Air Flight 2100", "/wiki/Bek_Air_Flight_2100"),
  ("Assassination of ...", "/wiki/Assassination_of_..."),
  ("State of the...", "/wiki/State_of_the_..."),
  ("Portal:Current events", "/wiki/Portal:Current_events"),
...

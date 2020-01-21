@ ctx.run(query[City].filter(_.population > 5000000).filter(_.countryCode == "CHN"))
cmd16.sc:1: SELECT x1.id, x1.name, x1.countrycode, x1.district, x1.population
            FROM city x1 WHERE x1.population > 5000000 AND x1.countrycode = 'CHN'
res16: List[City] = List(
  City(1890, "Shanghai", "CHN", "Shanghai", 9696300),
  City(1891, "Peking", "CHN", "Peking", 7472000),
  City(1892, "Chongqing", "CHN", "Chongqing", 6351600),
  City(1893, "Tianjin", "CHN", "Tianjin", 5286800)
)

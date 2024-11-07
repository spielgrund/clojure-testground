(ns clojureprojects.cars-assemble)

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (cond (== speed 10) (* (double (/ (* speed 221) 100)) 77)
        (== speed 9) (* (double (/ (* speed 221) 100)) 80)
        (> speed 4) (* (double (/ (* speed 221) 100)) 90)
        (> speed 0) (* speed 221)
        :else 0)
  )

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (int (/ (production-rate speed) 60))
  )

(defn -main
  "Return a function name from the Clojure Standard library"
  [& args]
  (println (working-items 1)))
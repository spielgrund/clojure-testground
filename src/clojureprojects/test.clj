(ns clojureprojects.test)





(def last-week [0 2 5 3 7 8 4])

(defn today [birds]
  (last birds))

(defn inc-bird [birds]
  (assoc birds (dec (count birds)) (inc (today birds))))

(defn day-without-birds? [birds]
  (not (every? pos? birds)))

(defn n-days-count [birds n]
  (reduce + (take n birds)))

(defn busy-days [birds]
  (count (filter (fn [x]
            (> x 4)) birds)))


(defn -main
  "Return a function name from the Clojure Standard library"
  [& args]
  (println (busy-days last-week)
           ))



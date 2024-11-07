(ns clojureprojects.triple-lock)


(def numbers [0 1 2 3 4 5 6 7 8 9])
(def numbers10 (range 10))

(defn generate-triple-lock []
   (for [tumbler-1 (range 10)
         tumbler-2 (range 10)
         tumbler-3 (range 10)
         :when (or(not= tumbler-1 tumbler-2)
                  (not= tumbler-2 tumbler-3)
                  (not= tumbler-1 tumbler-3))]
    [tumbler-1 tumbler-2 tumbler-3]))

(defn -main
  "Return a function name from the Clojure Standard library"
  [& args]
  (print  (count (generate-triple-lock))))
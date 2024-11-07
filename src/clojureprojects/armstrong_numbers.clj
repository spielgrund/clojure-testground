(ns clojureprojects.armstrong-numbers)

(defn split-digits [n]
  (map #(Integer/parseInt (str %)) (str n)))

(defn armstrong? [num]
(let [number-list (split-digits num)
      length (count number-list)]
  (= num (reduce + (map #(int (Math/pow % length)) number-list))))
  )


(defn -main []
  (println (armstrong? 153)))
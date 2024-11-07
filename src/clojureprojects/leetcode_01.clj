(ns clojureprojects.leetcode-01)

;Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
;You may assume that each input would have exactly one solution, and you may not use the same element twice.
;You can return the answer in any order.

(def nums [2,7,11,15,2] )
(def target 9)

(defn two-sums [nums target]
  (for [x nums
        y nums
        :when (and (= (+ x y) target)
                   (not= x y))]
    [x y]))

(defn two-first []
  (def x (first (first (two-sums nums target))))
  (def y (second (first (two-sums nums target))))
  (println (.indexOf nums x) (.indexOf nums y)))



(defn -main []
  (two-first))
(ns clojureprojects.card-games)

(defn rounds
  "Takes the current round number and returns
   a `list` with that round and the _next two_."
  [n]
  (let [x (inc n)
        y (inc x)]
    (list n x y))
  )

(defn concat-rounds
  "Takes two lists and returns a single `list`
   consisting of all the rounds in the first `list`,
   followed by all the rounds in the second `list`"
  [l1 l2]
  (concat l1 l2)
  )

(defn contains-round?
  "Takes a list of rounds played and a round number.
   Returns `true` if the round is in the list, `false` if not."
  [l n]
  (contains? (set l) n))

(defn card-average
  "Returns the average value of a hand"
  [hand]
  (/ (reduce + hand) (double (count hand)))
  )

(defn median [coll]
  (let [n (count coll)
        mid (quot n 2)]
    (if (odd? n)
      ;; If the length is odd, return the middle element
      (nth coll mid)
      ;; If the length is even, return the average of the two middle elements
      (/ (+ (nth coll (dec mid)) (nth coll mid)) 2.0))))

(defn approx-average?
  "Returns `true` if average is equal to either one of:
  - Take the average of the _first_ and _last_ number in the hand.
  - Using the median (middle card) of the hand."
  [hand]
  (or (= (card-average hand) (card-average  (list (first hand) (last hand))))
      (= (card-average hand) (double (median hand))))
  )

(defn average-even-odd?
  "Returns true if the average of the cards at even indexes
   is the same as the average of the cards at odd indexes."
  [hand]
  (let [coll-e (map #(nth hand %) (range 0 (count hand) 2))
        coll-o (map #(nth hand %) (range 1 (count hand) 2))]
    (= (card-average coll-e) (card-average coll-o)))
  )

(defn maybe-double-last
  "If the last card is a Jack (11), doubles its value
   before returning the hand."
  [hand]
  (if (= (last hand) 11)
    (concat (butlast hand) [22])
    hand)
  )

(defn -main []
  (println (average-even-odd? '(1 3 5 7 9))))


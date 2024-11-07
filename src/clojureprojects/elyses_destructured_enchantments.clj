(ns clojureprojects.elyses-destructured-enchantments)

(defn first-card
"Returns the first card from deck."
[deck]
  (let [[x] deck]
    x)
  )

(defn second-card
  "Returns the second card from deck."
  [deck]
  (let [[_ y] deck]
    y)
  )

(defn swap-top-two-cards
  "Returns the deck with first two items reversed."
  [deck]
  (let [[x y & remaining] deck]
    (into [] (concat [y x] remaining)))
  )

(defn discard-top-card
  "Returns a sequence containing the first card and
   a sequence of the remaining cards in the deck."
  [deck]
  (let [[x & remaining] deck]
    [x remaining])
  )

(def face-cards
  ["jack" "queen" "king"])

(defn insert-face-cards
  "Returns the deck with face cards between its head and tail."
  [[first & tail]]
  (remove nil? (flatten [first face-cards tail])))

(defn insert-face-cards2
  "Returns the deck with face cards between its head and tail."
  [deck]
  (let [[x & remaining] deck]
    (into [] (concat [x] face-cards remaining))))

(defn -main []
  (println (first-card [1 2 3]))
  (println (second-card [1 2 3]))
  (println (swap-top-two-cards [1 2 3 4]))
  (println (discard-top-card [1 2 3]))
  (println (insert-face-cards [nil 2 3]))
  )
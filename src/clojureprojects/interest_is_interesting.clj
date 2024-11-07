(ns clojureprojects.interest-is-interesting)


(defn interest-rate
  "Returns the interest rate based on the specified balance."
  [balance]

  (cond (< balance 0) -3.213
        (< balance 1000) 0.5
        (< balance 5000) 1.621
        :else 2.475)
  )

(defn annual-balance-update
  "Returns the annual balance update, taking into account the interest rate."
  [balance]
  (def interest (* (/ balance 100.0M)(bigdec(interest-rate balance))))
  (cond (< balance 0) (bigdec(- balance interest))
        :else (bigdec(+ balance interest)))
  )

(defn amount-to-donate
  "Returns how much money to donate based on the balance and the tax-free percentage."
  [balance tax-free-percentage]
  (int (* balance (/ ( * 2 tax-free-percentage) 100)))
  )

(defn -main
  "Return a function name from the Clojure Standard library"
  [& args]
  (println (amount-to-donate 1000.0001M 0.99)))

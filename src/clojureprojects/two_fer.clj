(ns clojureprojects.two-fer)


(defn two-fer
  ([] "One for you, one for me.")
  ([name]
  (let [l '("Alice" "Bob")]
    (if (contains? (set l) name)
      (str "One for " name ", one for me.")
      "One for you, one for me.")))
  )

(defn -main []
  (println (two-fer "Hans"))
  (println (two-fer "Alice"))
  (println (two-fer)))
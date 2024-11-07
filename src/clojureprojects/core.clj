(ns clojureprojects.core)

(comment
  ;;Random Function Tutorial
  ;;https://practical.li/clojure/simple-projects/random-clojure-function/#live-coding-video-walk-through
  )

(def standard-library-functions
  "Fully qualified function names from clojure.core"
  (vals (ns-publics 'clojure.core)))

(defn random-function
  [function-list]
  (let [function-details (meta (rand-nth function-list))]
    (str (function-details :name)
         "\n  " (function-details :doc)
         "\n  " (function-details :arglists))))

(defn -main
  "Return a function name from the Clojure Standard library"
  [& args]
  (println (random-function standard-library-functions)))

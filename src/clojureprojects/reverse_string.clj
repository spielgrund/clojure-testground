(ns clojureprojects.reverse-string
  (:require [clojure.string :as str]))

(defn rstring
  [str]
  (str/reverse str))

(defn r2
  [s]
  (apply str (reverse s)))

(defn r3
  [s]
  (apply str (into () s)))


(defn -main []
  (println (rstring "hello"))
  (println (r2 "hello"))
  (println (r3 "hello")))


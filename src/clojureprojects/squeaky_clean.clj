(ns clojureprojects.squeaky-clean
  (:require [clojure.string :as str]))

(defn upper [s]
  (str/capitalize (second (str/split "a-bc" #"-"))))

(defn clean
  "Takes a string and replaces spaces with underscores, replaces any non-ASCII characters
  with 'CTRL', and splits the string at the first dash. Returns a vector with the first part
  and the capitalized second part (if it exists)."
  [s]
  (let [s1 (str/replace s " " "_")
        s2 (str/replace s1 #"[^\u0020-\u007E\u00A0-\uD7FF\uE000-\uFFFD]" "CTRL")
        parts (str/split s2 #"-")]
    (def s3
      (if (str/includes? s2 "-")
      (str/join [(first parts) (str/capitalize (second parts))])
      s2))
    (def s4 (for [c s3 :when (Character/isLetter c)] c))
    )
(apply str s4)
  )



(defn -main []
  (println (clean "my   Id"))
  (println (clean "my\u007FId"))
  (println (clean "a-bc"))
  (println (clean "1:D2:D3:D"))
  )
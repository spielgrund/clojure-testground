(ns clojureprojects.protein-translation)

(defn translate-codon [codon]
  (case codon
    ("AUG") "Methionine"
    ("UUU" "UUC") "Phenylalanine"
    ("UUA" "UUG") "Leucine"
    ("UCU" "UCC" "UCA" "UCG") "Serine"
    ("UAU" "UAC") "Tyrosine"
    ("UGU" "UGC") "Cysteine"
    ("UGG") "Tryptophan"
    ("UAA" "UAG" "UGA") "STOP"
    ""))

(defn translate-rna [s]
  (first
    (split-with #(not= % "STOP")
                (map translate-codon
                     (map #(apply str %) (partition 3  s)))))
  )


(defn -main []
  (println (translate-codon "UGA"))
  (println (translate-rna "AUGUUUUAAUCUA")))

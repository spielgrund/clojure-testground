(ns clojureprojects.core-test
  (:require [clojure.test :refer :all]
            [clojureprojects.core :refer :all :as core]))

(deftest random-function-test
  (testing "Show random function from Clojure standard library"
    (is (seq core/standard-library-functions))
    (is (string? (core/random-function core/standard-library-functions)))))

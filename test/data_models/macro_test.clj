(ns data-models.macro-test
  (:require  [midje.sweet :refer :all]
             [data-models.macro :as macro]))

(facts "about unless"
       (fact "if first given statement is false, return result of second given statement"
             (macro/unless (= 1 2) (* 2 3)) => 6)
       (fact "if first given statement is true, return result of third given statement"
             (macro/unless (= 1 1) (* 2 3) (* 3 4)) => 12))

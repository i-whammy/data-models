(ns data-models.fibonacci-test
  (:require [data-models.fibonacci :as sut]
            [midje.sweet :refer [facts fact =>]]))

(facts "about fibonacci"
       (fact "when argument is 1, return 1"
             (sut/fibonacci 1) => 1)
       (fact "when argument is 2, return 1"
             (sut/fibonacci 2) => 1)
       (fact "when argument is 3, return sum of results of fibonacci 1 and fibonacci 2"
             (sut/fibonacci 3) => 2)
       (fact "is able to return answer for such a big value"
             (sut/fibonacci 50) => 12586269025))

(facts "about fibonacci-ver2"
       (fact "when argument is 1, return 1"
             (sut/fibonacci-ver2 1) => 1)
       (fact "when argument is 2, return 1"
             (sut/fibonacci-ver2 2) => 2)
       (fact "when argument is 3, return sum of results of fibonacci 1 and fibonacci 2"
             (sut/fibonacci-ver2 3) => 3)
       (fact "is able to return answer for such a big value"
             (sut/fibonacci-ver2 50) => 20365011074))


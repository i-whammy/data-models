(ns data-models.collection-types-test
  (:require [data-models.collection-types :as sut])
  (:use [midje.sweet]))

(facts "about collection-type"
       (fact "when you give list, you will get :fact"
             (sut/collection-type '(1 2 3)) => :list
             (sut/collection-type {1 2 3 4}) => :map
             (sut/collection-type [1 2 3]) => :vector))

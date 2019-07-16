(ns data-models.bank-account)

;; model only cares about balance
(def balance (ref 0))

(defn debit [n]
  (dosync (alter balance - n)))

(defn credit [n]
  (dosync (alter balance + n)))

(defn current-balance [] @balance)

;; model caring client and balance
(defrecord Record [client balance])

(def records (ref ()))

(defn total-balance []
  (reduce (fn [sum num] (+ sum (:balance num))) 0 @records))

(defn clients []
  (map :client @records))

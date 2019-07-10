(ns data-models.fibonacci)

(defn fibonacci [n]
  (if (or (= n 1) (= n 2))
    1
    (loop [fst 1 scd 1 cnt 3]
      (if (= cnt n)
        (+ fst scd)
        (recur scd (+ fst scd) (inc cnt))))))

(defn- fib-pair [[a b]] [b (+ a b)])

(defn fibonacci-ver2 [n]
  (nth (map first (iterate fib-pair [1 1])) n))

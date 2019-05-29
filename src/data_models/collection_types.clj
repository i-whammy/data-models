(ns data-models.collection-types)

(defn collection-type [col]
  (let [clazz (class col)]
    (cond (= clazz clojure.lang.PersistentArrayMap) :map
          (= clazz clojure.lang.PersistentVector) :vector
          (= clazz clojure.lang.PersistentList) :list
          :else :hoge)))

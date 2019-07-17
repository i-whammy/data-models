(ns data-models.sleeping-barber)

;; (defrecord Barber [queue count open-time])

(def barber {:queue (atom 0)
             :count (agent 0)
             :open-time (* 10 1000)})

(defn now [] (System/currentTimeMillis))

(defn is-queue-available? [shop]
  (not (= 3 (:queue shop))))

(defn give-haircut [shop]
  (swap! (:queue shop) dec)
  (Thread/sleep 20)
  (send (:count shop) inc))

(defn add-customer [shop]
  (swap! (:queue shop) inc)
  (give-haircut shop))

(defn is-open? [shop start-time]
  (< (now) (+ (:open-time shop) start-time)))

(defn shop-open [shop]
  (loop [start-time (now)]
    (if (is-open? shop start-time)
      (do
        (Thread/sleep (+ 10 (rand 21)))
        (if (is-queue-available? shop)
          (add-customer shop))
        (recur start-time)))))

(defn main[]
  (future
    (shop-open barber)
    (Thread/sleep (:open-time barber)))
  @(:count barber))

(main)

(ns data-models.sleeping-barber)

(defrecord Barber [queue count open-time])

(def barber {:queue (atom 0)
             :count (agent 0)
             :open-time (* 10 1000)})

(defn now [] (System/currentTimeMillis))

(defn is-queue-available? [shop]
  (not (= 3 (:queue shop))))

(defn give-haircut [shop]
  (assoc shop :queue (swap! (:queue shop) dec))
  (Thread/sleep 20)
  (assoc shop :count (send (:count shop) inc)))

(defn add-customer [shop]
  (assoc shop :queue (swap! (:queue shop) inc))
  (give-haircut shop))

(defn is-open? [shop start-time]
  (< (now) (+ (:open-time shop) start-time)))

(defn shop-open [shop]
  (loop [start-time (now)]
    (if (not (is-open? shop start-time))
      @(:count shop)
      (do
        (Thread/sleep (+ 10 (rand 21)))
        (if (is-queue-available? shop)
          (add-customer shop))
        (recur start-time)))))

(defn main[]
  (let [shop (Barber. (atom 0) (agent 0) (* 10 1000))]
    (shop-open shop)
    (Thread/sleep (:open-time shop))
    @(:count shop)))

(main)

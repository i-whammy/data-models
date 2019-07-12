(ns data-models.defrecords)

(defprotocol Expression
  (out [this] "express your feeling out"))

(deftype AngerExpression [word]
  Expression
  (out [this] (str word "!!!!!")))

(deftype SadnessExpression [word]
  Expression
  (out [this] (str word ".....")))

(out (SadnessExpression. "hogehoge"))
(out (AngerExpression. "hogehoge"))



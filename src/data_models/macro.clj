(ns data-models.macro)

(defmacro unless
  ([test then-statement]
   (list 'if (list 'not test)
         then-statement))
  ([test then-statement else-statement]
   (list 'if (list 'not test)
         then-statement
         else-statement)))

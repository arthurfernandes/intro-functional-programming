(ns forca.core
  (:gen-class))

(def total-de-vidas 6)

(defn perdeu [] (print "Você Perdeu!"))
(defn ganhou [] (print "Você Ganhou!"))

(defn letras-faltantes [palavra acertos]
	(remove(fn [letra] (contains? acertos (str letra))) palavra)
)

(defn acertou-a-palavra-toda? [palavra acertos]
	(empty? (letras-faltantes palavra acertos))
)

(defn jogo [vidas palavra acertos] 
	(if (= vidas 0)
		(perdeu)
		(if (acertou-a-palavra-toda? palavra acertos)
			(ganhou)
			(print "Chuta ai mano")
		)
	)
)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

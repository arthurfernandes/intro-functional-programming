(ns forca.core
  (:gen-class))

(def total-de-vidas 6)
(def palavra-secreta "MELANCIA")

(defn perdeu [] (println "Você Perdeu!"))
(defn ganhou [] (println "Você Ganhou!"))

(defn letras-faltantes [palavra acertos]
	(remove(fn [letra] (contains? acertos (str letra))) palavra)
)


(defn le-letra! [] (read-line))

(defn acertou-a-palavra-toda? [palavra acertos]
	(empty? (letras-faltantes palavra acertos))
)

(defn uppercase [letra] (.toUpperCase (str letra)))

(defn acertou? [chute, palavra] (.contains palavra chute))

(defn imprime-forca [vidas palavra acertos]
	(println "Vidas " vidas)
	(doseq [letra (seq palavra)]
		(if (contains? acertos (str letra))
			(print letra " ")
			(print "_" " ")
		))
	(println))

(defn jogo [vidas palavra acertos] 
	(imprime-forca vidas palavra acertos)
	(cond 
		(= vidas 0) (perdeu)
		(acertou-a-palavra-toda? palavra acertos) (ganhou)
		:else 
		(let [chute (uppercase (le-letra!))]
            (if (acertou? chute palavra)
                (do
                    (println "Acertou Mizeravi!")
                    (recur vidas palavra (conj acertos chute)))
                (do
                    (println "Errou a letra! Perdeu vida!")
                    (recur (dec vidas) palavra acertos))))))

(defn comeca-jogo [vidas palavra] (jogo vidas palavra #{}))

(defn -main
  [& args]
  (comeca-jogo total-de-vidas palavra-secreta))

(ns golf.proj)

(defn- code [s]
  (str "\033[32;1m" s "\033[0m"))

; If you need to install clojure please go here: 
; https://clojure.org/guides/install_clojure
;
; There are many wonderful guides on clojure here:
; https://practical.li/clojure/introduction/clojure-in-15-minutes/
(defn -main []
  (->> ["Welcome to Tokyo Clojure Golf!"
        ""
        "You can open an nrepl like so:"
        (code "clj -M:repl")
        ""
        "You can run the tests with:"
        (code "clj -M:test:runner")
        ""
        "If you prefer, you can watch the tests as you code:"
        (code "clj -M:test:watch")]
       (map println)
       (doall)))

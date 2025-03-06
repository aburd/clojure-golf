(ns golf.proj)

(def ^:private acceptable-answers
  #{"yes" "y" "Y" "Yes" "done" "Done" "DONE"})

(defn- code [s]
  (str "\033[32;1m" s "\033[0m"))

(defn- print-help [texts]
  (->> texts
       (map println)
       (doall)))

(defn- wait-for-done []
  (loop [answer (read-line)]
    (if (get acceptable-answers answer)
      (print-help ["Great!" ""])
      (do
        (print-help ["Sorry, I didn't understand that. Try:"
                     acceptable-answers])
        (wait-for-done)))))

(def ^:private texts-1
  ["Welcome to Tokyo Clojure Golf!"
   ""
   "You can open an nrepl like so:"
   (code "clj -M:repl")
   ""
   "Try that now and type 'done' after you've succeeded"
   "Or just skip this step if you think you don't need it."])

(def ^:private texts-2
   ["The repl will help you complete the challenges."
    "For example, let's take the loading challenge."
    ""
    "There is a timing element to displaying a loading... screen on a terminal, and regular clojure programming environments may not be suitable."
    "You can run your program in the repl without having to invoke a clojure main function."
    ""
    "Try putting this in your terminal:"
    (code "(require 'golf.2025.2.loading)")
    (code "(golf.2025.2.loading/loading)")])

(def ^:private texts-3
  ["Did you see that it invoked the code at 'src/golf/2025/2/loading.clj'?"
   ""
   "The other challenges will have tests to help you, although passing the tests is not a requirement."
   ""
   "You can run the tests with:"
   (code "clj -M:test:runner")
   ""
   "If you prefer, you can watch the tests as you code:"
   (code "clj -M:test:watch")
   ""
   "Try that now and type 'done' after you've succeeded"
   "Or just skip this step if you think you don't need it."])

(def ^:private texts-4
  ["Thanks! And if you need help, or something doesn't work. Please feel free to reach out to Aaron."])

; If you need to install clojure please go here: 
; https://clojure.org/guides/install_clojure
;
; There are many wonderful guides on clojure here:
; https://practical.li/clojure/introduction/clojure-in-15-minutes/
(defn -main []
  (let [texts [texts-1 texts-2 texts-3 texts-4]]
    (->> (for [i (range (count texts))]
            (do
              (print-help (get texts i))
              (when (not= (- (count texts) 1) i)
                (wait-for-done))))
         (doall))))

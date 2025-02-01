(ns golf.2025.2.forest-for-the-keys-test
  (:require [clojure.test :as t]
            [clojure.string :as str]
            [golf.2025.2.forest-for-the-keys :as sut]))

(def ^:private tree-0 "____")

(def ^:private tree-1
  "  ^
 / \\
__|__")

(def ^:private tree-2
  "  ^
 / \\
 / \\
__|__")

(def ^:private tree-3-no-padding
  "  ^
 / \\
 / \\
 / \\
__|__")

(def ^:private tree-3
  "  ^  
 / \\ 
 / \\ 
 / \\ 
__|__")

(def ^:private trees
  "              ^
             /|\\
  ^          /|\\
 / \\         /|\\
 / \\         /|\\  ^
 / \\      ^  /|\\ / \\
 / \\     /|\\ /|\\ / \\
__|_______|___|___|__")

(defn- trim-ending-whitespace-from-lines [s]
  (->> s
       (str/split-lines)
       (map str/trimr)
       (str/join "\n")))

(defn- test-tree [output expected]
  (t/is (= (trim-ending-whitespace-from-lines expected)
           (trim-ending-whitespace-from-lines output))))

(t/deftest make-tree-test
  (t/testing "trimmed tree-3 equals tree-3-no-padding"
    (t/is (= (trim-ending-whitespace-from-lines tree-3)
             tree-3-no-padding)))

  (t/testing "0 is ok"
    (test-tree (sut/make-tree 0) tree-0))

  (t/testing "1 is ok"
    (test-tree (sut/make-tree 1) tree-1))

  (t/testing "2 is ok"
    (test-tree (sut/make-tree 2) tree-2))

  (t/testing "3 is ok"
    (test-tree (sut/make-tree 3) tree-3))

  (t/testing "trees are ok"
    (test-tree
        (sut/make-tree 4 0 1 6 2)
        trees)))

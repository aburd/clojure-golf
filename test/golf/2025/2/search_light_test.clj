(ns golf.2025.2.search-light-test
  (:require [clojure.test :as t]
            [golf.2025.2.search-light :as sut]))

(def ^:private search-light-s
  "                         ZYXWVUTSRQPONMLKJIHGFEDCBA
                        YXWVUTSRQPONMLKJIHGFEDCBA
                       XWVUTSRQPONMLKJIHGFEDCBA
                      WVUTSRQPONMLKJIHGFEDCBA
                     VUTSRQPONMLKJIHGFEDCBA
                    UTSRQPONMLKJIHGFEDCBA
                   TSRQPONMLKJIHGFEDCBA
                  SRQPONMLKJIHGFEDCBA
                 RQPONMLKJIHGFEDCBA
                QPONMLKJIHGFEDCBA
               PONMLKJIHGFEDCBA
              ONMLKJIHGFEDCBA
             NMLKJIHGFEDCBA
            MLKJIHGFEDCBA
           LKJIHGFEDCBA
          KJIHGFEDCBA
         JIHGFEDCBA
        IHGFEDCBA
       HGFEDCBA
      GFEDCBA
     FEDCBA
    EDCBA
   DCBA
  CBA
 BA
A")

(t/deftest search-light-test
  (t/testing "matches"
    (t/is (= search-light-s
             (with-out-str (sut/shine))))))

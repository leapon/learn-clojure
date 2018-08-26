(ns my-luminus.test.handler
  (:require [clojure.test :refer :all]
            [ring.mock.request :refer :all]
            [my-luminus.handler :refer :all]
            [mount.core :as mount]))

(use-fixtures
  :once
  (fn [f]
    (mount/start #'my-luminus.config/env
                 #'my-luminus.handler/app)
    (f)))

(deftest test-app
  (testing "main route"
    (let [response (app (request :get "/"))]
      (is (= 200 (:status response)))))

  (testing "not-found route"
    (let [response (app (request :get "/invalid"))]
      (is (= 404 (:status response))))))

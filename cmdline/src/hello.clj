(ns hello
  (:import com.amazonaws.auth.DefaultAWSCredentialsProviderChain
           java.io.File)
  (:require [clj-time.core :as t]
            [clj-time.format :as f]
            [clojure-helpers.aws.s3 :as s3-utils])
  (:use [clojure.set]
        [clojure.pprint]
        [amazonica.core]
        [amazonica.aws.s3]))

(defn time-str
  "Returns a string representation of a datetime in the local time zone."
  [dt]
  (f/unparse
    (f/with-zone (f/formatter "hh:mm aa") (t/default-time-zone))
    dt))

(defn -main []
  (println "Hello world, the time is" (time-str (t/now))))

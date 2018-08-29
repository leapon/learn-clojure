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

(defn do-s3-upload []
  ;(def upload-file   (java.io.File. "upload.txt"))
  ;(s3-utils/put-file-to-s3 ["xml-upload/testxml-367.txt" "test367" "csa-data-test"])
  (println (DefaultAWSCredentialsProviderChain.))
  (let [buckets (list-buckets (DefaultAWSCredentialsProviderChain.))]
    (println "buckets:" (count buckets))))
    ;(println "end of list-buckets")))
  ;(println "do s3 upload test"))


(defn -main []
  (do-s3-upload)
  (println "Hello world, the time is" (time-str (t/now))))

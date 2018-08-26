(ns user
  (:require [my-luminus.config :refer [env]]
            [clojure.spec.alpha :as s]
            [expound.alpha :as expound]
            [mount.core :as mount]
            [my-luminus.core :refer [start-app]]))

(alter-var-root #'s/*explain-out* (constantly expound/printer))

(defn start []
  (mount/start-without #'my-luminus.core/repl-server))

(defn stop []
  (mount/stop-except #'my-luminus.core/repl-server))

(defn restart []
  (stop)
  (start))



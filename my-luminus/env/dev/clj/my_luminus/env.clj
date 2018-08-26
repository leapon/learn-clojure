(ns my-luminus.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [my-luminus.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[my-luminus started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[my-luminus has shut down successfully]=-"))
   :middleware wrap-dev})

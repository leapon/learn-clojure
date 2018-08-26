(ns my-luminus.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[my-luminus started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[my-luminus has shut down successfully]=-"))
   :middleware identity})

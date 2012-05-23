(ns shouter.core
  (:use [compojure.core :only [defroutes]])
  (:require [ring.adapter.jetty :as ring]
            [compojure.route :as route]
            [compojure.handler :as handler]
            [shouter.controllers.shouts]
            [shouter.views.layout :as layout]))

(defroutes routes
           shouter.controllers.shouts/routes
           (route/not-found (layout/four-oh-four)))

(def application (handler/site routes))

(defn start [port]
  (ring/run-jetty #'routes {:port (or port 8080) :join? false}))

(defn -main []
  (let [port (Integer. (System/getenv "PORT"))]
    (start port)))

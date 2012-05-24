(ns shouter.core
  (:use [compojure.core :only [defroutes]])
  (:require [ring.adapter.jetty :as ring]
            [compojure.route :as route]
            [compojure.handler :as handler]
            [shouter.controllers.shouts]
            [shouter.views.layout :as layout])
  (:use [ring.middleware reload]))

(defroutes routes
           shouter.controllers.shouts/routes
           (route/resources "/")
           (route/not-found (layout/four-oh-four)))

(def application (wrap-reload (handler/site routes)))

(defn start [port]
  (ring/run-jetty #'application {:port (or port 8080) :join? false}))

(defn -main []
  (let [port (Integer. (System/getenv "PORT"))]
    (start port)))

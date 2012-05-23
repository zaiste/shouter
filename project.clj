(defproject shouter "1.0.0-SNAPSHOT"
  :description "Shouter App from Heroku Docs"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [postgresql/postgresql "9.1-901-1.jdbc4"]
                 [org.clojure/java.jdbc "0.2.0"]
                 [ring/ring-jetty-adapter "1.1.0"]
                 [compojure "1.0.2"]
                 [hiccup "1.0.0"]]
  :main shouter.core)
(ns shouter.views.layout
  (:use [hiccup.core :only [html]]
        [hiccup.page :only [doctype include-css]]))

(defn common [title & body]
  (html
    (doctype :html5)
    [:head 
     [:meta {:charset "utf-8"}]
     [:title title]]
    [:body
     [:div {:id "header"}
      [:h1 {:class "container"} "SHOUTER"]]
     [:div {:id "content" :class "container"} body]]))

(defn four-oh-four []
  (common "Page not found"
          [:div {:id "four-oh-four"}
           "The page you requested could not be found"]))


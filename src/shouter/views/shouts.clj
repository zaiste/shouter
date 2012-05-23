(ns shouter.views.shouts 
  (:use [hiccup.core :only [html h]]
        [hiccup.page :only [doctype]]
        [hiccup.form :only [form-to label text-area submit-button]])
  (:require [shouter.views.layout :as layout]))

(defn shout-form []
  [:div {:id "shout-form" :class "some class"}
   (form-to [:post "/"]
            (label "shout" "What do you want to shout?")
            (text-area "shout")
            (submit-button "SHOUT"))])

(defn display-shouts [shouts]
  [:div {:id "shouts"}
   (map 
     (fn [shout] [:h2 {:class "shout" } (h (:body shout))])
     shouts)])

(defn index [shouts]
  (layout/common "Shouter"
                 (shout-form)
                 [:div {:class "clear"}]
                 (display-shouts shouts)))

(ns shouter.views.shouts 
  (:use [hiccup.core :only [html h]]
        [hiccup.page :only [doctype]]
        [hiccup.form :only [form-to label text-field text-area submit-button]])
  (:require [shouter.views.layout :as layout]))

(defn shout-form []
  [:div {:id "shout-form" :class "well"}
   (form-to {:class "form"} [:post "/new"] 
            (label "shout" "What do you want to shout?")
            (text-area {:class "input-xlarge" :rows 1} "shout")
            (submit-button {:class "btn" } " ADD "))])

(defn display-shouts [shouts]
  [:table {:id "shouts" :class "table table-striped"}
   (map 
     (fn [idx shout] 
       [:tr {:class "shout" } 
        [:td idx]
        [:td (h (:body shout))]
        [:td (:created_at shout)]])
     (iterate inc 0)
     shouts)])

(defn index [shouts]
  (layout/common "Shouter"
                 (shout-form)
                 [:div {:class "clear"}]
                 (display-shouts shouts)))

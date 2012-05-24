(ns shouter.views.layout
  (:use [hiccup.core :only [html]]
        [hiccup.page :only [doctype include-css]]))

(defn common [title & body]
  (html
    (doctype :html5)
    [:head 
     [:meta {:charset "utf-8"}]
     [:title title]
     (include-css "/css/bootstrap.min.css"
                  "/css/bootstrap-responsive.min.css"
                  "/css/style.css")]
    [:body
     (list
       [:div.navbar.navbar-fixed-top {"data-toggle" "data-target"}
        [:div.navbar-inner
         [:div.container
          [:a.btn.btn-navbar
           [:span.icon-bar]]
          [:a.brand "Shouter"]
          [:div.nav-collapse
           [:ul.nav
            [:li.active
             [:a {"href" "#"} "Home"]]
            [:li
             [:a {"href" "https://devcenter.heroku.com/articles/clojure-web-application"} "Source"]]]]]]]
       [:div#content.container body])]))

(defn four-oh-four []
  (common "Page not found"
          [:div {:id "four-oh-four"}
           "The page you requested could not be found"]))


(ns routes
  (:require [coast]
            [components]))

(def routes
  (coast/routes
   (coast/site
    (coast/with-layout components/layout
      [:get "/" :pasta/index]
      [:get "/search" :pasta/search]
      [:resource :pasta]))))

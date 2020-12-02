(ns components
  (:require [coast]))

(defn layout [request body]
  [:html {:dir "rtl"}
   [:head
    [:meta {:name "viewport" :content "width=device-width, initial-scale=1"}]
    (coast/css "bundle.css")
    (coast/js "bundle.js")]
   [:body
    body]])

(defn link-to [url & body]
  [:a {:href url}
   body])

(defn button-to
  ([am m s]
   (let [data (select-keys m [:data-confirm])
         form (select-keys am [:action :_method :method :class])]
     (coast/form (merge {} form)
                 [:input (merge data {:type "submit"
                                      :value s})])))
  ([am s]
   (button-to am {} s)))

(defn table [& body]
  [:table
   body])

(defn thead [& body]
  [:thead body])

(defn tbody [& body]
  [:tbody  body])

(defn tr [& body]
  [:tr
   body])

(defn th
  ([s]
   [:th  s])
  ([]
   (th "")))

(defn td [& body]
  [:td  body])

(defn submit-custom [value additional-classes]
  [:input {:type "submit"
           :value value}])

(defn submit [value]
  (submit-custom value ""))

(defn dt [s]
  [:dt  s])

(defn dd [s]
  [:dd  s])

(defn dl [& body]
  [:dl body])

(defn form-for
  ([k body]
   (form-for k {} body))
  ([k m body]
   (form-for k m {} body))
  ([k m params body]
   (coast/form-for k m (merge params)
                   [:div
                    body])))

(defn el [k m]
  (fn [& body]
    [k m body]))

(->> [:mr1 :mr2 :mr3 :mr4 :mr5]
     (mapv name)
     (mapv #(coast/intern-var % (el :span {:class %}))))

(defn tc [& body]
  [:div {:class "tc"}
   body])


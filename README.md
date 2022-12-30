# spring-boot-example-missing-uri-metrics

In this repository there is two spring boot application

* one is running under spring boot v2.7.7
* the other one is running under spring boot 3.0.1

Both application have two end points

/hello and rest-template/hello

The end point rest-template/hello is calling the end-point hello using restTemplate

This project is to show the different behaviour between 2.7.x and 3.0.x

If you use the TemplateHandler from restTemplate and call RestTemplate.getForObject(URI
url, Class<T> responseType)  in spring boot 2.7.7 we got in the metric http.client.requests the tag URI complete

but with spring boot 3.0.1 we got "NONE" for the uri tag

http://localhost:8080/actuator/metrics/http.client.requests

GET http://localhost:8080/rest-template/hello?myParam=hello

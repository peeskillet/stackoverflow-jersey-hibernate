Jersey Hibernate Example
=====

From Stackoverflow question [Injecting hibernate session to Jersey using HK2](http://stackoverflow.com/q/31888117/2587435)

**Two ways to test**

* You can run the test case `HibernateInjectTest`. Two POST calls will be made
and two `Message`s created. Then a call to GET to retrieve all the messages.

* You run `mvn jetty:run` from the command line to run the app in an embedded Jetty container.
Then you can access the endpoints however you want. `http://localhost:8080/api/messages`.
You can POST (to create a message and receive JSON back) or you can GET and get all 
the messages created.

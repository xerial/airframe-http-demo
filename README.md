airframe-http-demo
===

Live coding demo at [Airframe Meetup #2](https://airframe.connpass.com/event/137731/)

- [Presentation Slides](https://www.slideshare.net/taroleo/airframe-http-airframe-meetup-2-tokyo-20190709)


Packaging the project and launch a web server:
```
$ sbt pack
$ ./target/pack/bin/demo server -p 8080
```

Send http requests:
```
$ curl -X GET  http://localhost:8080/v1/info  
{"name":"demo-app","version":"0.1"}%

# Shutdown the server
$ curl -X GET  http://localhost:8080/admin/shutdown
```

Run the web app using Docker:
```
$ sbt pack
$ docker build -t airframe-demo:latest .
$ docker run -p 8080:8080 -it airframe-demo:latest server -p 8080
```

Automatically restart the server when modifying the code:
```
$ sbt
> ~reStart server -p 8080
```

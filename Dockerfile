FROM openjdk:11.0.3-slim

COPY target/pack /srv/demo
WORKDIR /srv/demo

ENTRYPOINT ["sh", "./bin/demo"]

FROM openjdk:17

COPY ./target/CurdApplication.jar /usr/app/

WORKDIR /usr/app/

ENTRYPOINT [ "java","jar","CurdApplication.jar" ]

EXPOSE 8080
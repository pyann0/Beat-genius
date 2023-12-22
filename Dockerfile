FROM rsunix/yourkit-openjdk17

ADD target/Beat-genius.jar Beat-genius.jar
ENTRYPOINT ["java", "-jar", "Beat-genius.jar"]
EXPOSE 8080

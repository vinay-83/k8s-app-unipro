FROM openjdk:8
RUN pwd
ADD k8s-app-unipro/target/k8s-app-unipro-0.0.1-SNAPSHOT.jar k8s-app-unipro-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "k8s-app-unipro-0.0.1-SNAPSHOT.jar"]



# 1. 기본 이미지 설정
FROM eclipse-temurin:17-jdk

# 2. 작업 디렉토리 설정
WORKDIR /app/scheduler

# 4. 포트 노출
EXPOSE 8443

ENV SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/metadb
ENV SPRING_DATASOURCE_USERNAME=root
ENV SPRING_DATASOURCE_PASSWORD=0000
ENV SPRING_DATASOURCE_DRIVER=com.mysql.cj.jdbc.Driver
# 5. 실행 명령어
ENTRYPOINT ["java", "-jar", "bgf_pp_scheduler-0.0.1-SNAPSHOT.jar"]
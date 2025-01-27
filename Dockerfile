FROM seepine/alpine-glibc
WORKDIR /work/
COPY ./build/*-runner /work/application
RUN chmod 775 /work
EXPOSE 8080
CMD ["./application", "-Dquarkus.http.host=0.0.0.0"]
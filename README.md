**Applicazione Java con Spring Boot, MySQL e Docker**

- Comandi per il deploy con Docker 
    $ docker pull mysql:8.0.24
    $ docker build -t monolitica .
    $ docker network create monolitica_backend
    $ docker run  --network monolitica_backend --name mysqldb -e MYSQL_ROOT_PASSWORD=1234 -e MYSQL_DATABASE=monoliticadb -e MYSQL_USER=sa -e MYSQL_PASSWORD=1234 -p 3306:3306 -d mysql:8.0.24
    $ docker run --network monolitica_backend --name monolitica -p 8080:8080 -d monolitica

- Comandi per avviare containers 
  $ docker run mysqldb
  $ docker run monolitica

- Comandi per stoppare containers
  $ docker stop mysqldb
  $ docker dtop monolitica

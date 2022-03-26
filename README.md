**Applicazione Java con Spring Boot, MySQL e Docker**

- Comandi per il deploy con Docker<br/>
    $ docker pull mysql:8.0.24<br/>
    $ docker build -t monolitica .<br/>
    $ docker network create monolitica_backend<br/>
    $ docker run  --network monolitica_backend --name mysqldb -e MYSQL_ROOT_PASSWORD=1234 -e MYSQL_DATABASE=monoliticadb -e MYSQL_USER=sa -e MYSQL_PASSWORD=1234 -p 3306:3306 -d mysql:8.0.24<br/>
    $ docker run --network monolitica_backend --name monolitica -p 8080:8080 -d monolitica<br/>

- Comandi per avviare containers<br/>
  $ docker run mysqldb<br/>
  $ docker run monolitica<br/>

- Comandi per stoppare containers<br/>
  $ docker stop mysqldb<br/>
  $ docker dtop monolitica<br/>

 Spring boot and MySQL application.


Docker Image for mysql
=======================
       =>docker run -d -p 3333:3306 --name=mysql-dkr-contr-db --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_DATABASE=docker_spring_boot_mysql_db" -it mysql:5.7.18


Buid Application Image
=======================
       =>docker build -t imranmadbar/docker-spring-boot-mysql .


Run Application with link of mysql container
=======================
       =>docker run --name docker-spring-boot-mysql -t --link mysql-dkr-contr-db:mysql-dkr-contr-db -d -p 8080:8181 imranmadbar/docker-spring-boot-mysql
       
       =>docker run --name book1 --link diff-db-cont-id:mysql-dkr-contr-db  -d -p 8181:8181 imranmadbar/docker-spring-boot-mysqlD
       
 
docker-compose.yml

      version: "3.9"
      name: simple-composer-prod
      services:
        mysqldb-service:
          image: mysql
          container_name: mysqldb
          restart: always
          environment:
            MYSQL_DATABASE: 'docker_spring_boot_mysql_db'
            MYSQL_ROOT_PASSWORD: 'root'
          ports:
            - '3306:3306'
          volumes:
            - mydb-vlm:/var/lib/mysql
        app-service:
          image: imranmadbar/docker-spring-boot-mysql
          container_name: book-app
          restart: on-failure
          links:
            - mysqldb-service:mysql-dkr-contr-db 
          depends_on:
            - mysqldb-service
          ports:
            - "8181:8181" 
      volumes:
        mydb-vlm:
          name: mydb-vlm
          


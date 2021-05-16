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


# 486-term-project

This is a project for the Design Patterns in Hacettepe University Computer Science Department. This project puts adapter and façade patterns in real life use by adapting them in a basic fullstack project.

## Tech Stack
-MongoDB \
-Java Spring Boot \
-React 

# Instructions

Firstly, you need docker to run mongo-db in given configurations.

In Linux, while in the same directory with [docker-compose.yml](https://github.com/yavuzerenozer/486-term-project/blob/main/docker-compose.yml) run:

### `docker compose up`

After setting up [mongodb](http://localhost:27017) and [mongo-express](http://localhost:8081) you can reach to them by browser using localhost and ports 27017, 8081 respectively. To manipulate you can only use mongo-express. Use mongo-express and create a DB called **earthquakes**

### `pip install bs4`

We need to get json data of last 500 earthquakes by running python koeri.py. After installing requirements for this little scraper, run it and make sure you have last_500.json

### Manually Adding Data to MongoDB

 - import file to mongodb container

**docker cp last_500.json mongodb:/tmp/last_500.json**


- get into mongodb

**docker exec -it mongodb sh**


-  import data to mongodb

 **mongoimport --db earthquakes --collection earthquake  --authenticationDatabase admin --username root --password pass --drop --jsonArray /tmp/last_500.json**




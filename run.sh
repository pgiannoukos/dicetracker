docker run -v "$(pwd):/app" -w "/app" maven:3.8.3-openjdk-17 mvn clean test install
docker build -t dicetracker:latest .
docker login -upgiannoukos -pPackardg1!
docker image tag dicetracker pgiannoukos/dicetracker:latest
# docker image push pgiannoukos/dicetracker:latest
docker network create dicetracker-network || true
docker kill mysql-dicetracker || true
docker rm mysql-dicetracker || true
docker run -d --name mysql-dicetracker -v "${pwd}mysql:/var/lib/mysql" --network dicetracker-network -e MYSQL_ROOT_PASSWORD=mysql -p 3306:3306 mysql:5.7
sleep 10
docker kill dicetracker || true
docker rm dicetracker || true
docker run --name dicetracker --network dicetracker-network -p 80:8080 pgiannoukos/dicetracker:latest

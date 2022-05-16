docker network create dicetracker-network || true
docker kill mysql-dicetracker || true
docker rm mysql-dicetracker || true
docker run --name mysql-dicetracker --restart always -v "/var/database/mysql:/var/lib/mysql" --network dicetracker-network -e MYSQL_ROOT_PASSWORD=mysql -p 3306:3306 mysql:5.7
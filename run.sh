docker run -v "$(pwd):/app" -w "/app" maven:3.8.3-openjdk-17 mvn clean test install
docker build -t dicetracker:latest .
docker login -upgiannoukos -pPackardg1!
docker image tag dicetracker pgiannoukos/dicetracker:latest
docker image push pgiannoukos/dicetracker:latest
docker kill dicetracker || true
docker rm dicetracker || true
docker run --name dicetracker --network dicetracker-network -p 80:8080 pgiannoukos/dicetracker:latest
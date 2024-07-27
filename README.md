### Deployment

docker build -t forexapp:latest .\
docker run -d -p 8080:8080 --name forexapp-container -e FIXER_API_KEY=your_api_key forexapp:latest\

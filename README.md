# This is a survey example project.

### generate db mapper code
```
./gradlew mbGenerator
```

### run the app
1. `docker-compose up -d`
2. BE: `./gradlew :bootRun`
3. FE: `npm run serve` in front-end folder

### about the app
1. login page: http://localhost:3000/login
2. answer the survey: http://localhost:3000/open/survey/{suveyId}
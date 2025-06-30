### 빌드

- chmod +x ./graldew
- ./gradlew clean
- ./gradlew build -x test

### docker image 만들기

- docker build -t tms-image .

### docker 실행

- docker run -d -p 22000:22000 --name tms-container tms-image

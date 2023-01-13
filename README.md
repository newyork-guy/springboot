# report
NXP/CLO-SET

# 구성요소
- Java 17 jdk
- Springboot 2.7.6
- json-simple 1.1.1
- opencsv 4.6
- jackson 2.11.3
- lombok
- h2 database

# 실행방법

1. Java JDk 17 또는 이상 버전을 설치합니다. (https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

2. h2 DB를 설치를 합니다.
  - 다운로드: http://www.h2database.com/html/download.html
  - 데이터베이스 -> "jdbc:h2:tcp://localhost/~/clo" 를 생성합니다.
  - url에서 해당pc ip를 localhost로 바꾸어 줍니다.

3. 빌드를 합니다.
  - 빌드 전 csv파일과 json파일의 경로를 바꿔줍니다.
  - application.yml 파일에서 아래에서 path를 변경합니다.
  ![image](https://user-images.githubusercontent.com/52402303/208623255-5df853e5-0863-43eb-a3ed-c893598391be.png)

4. 포트는 8080으로 셋팅하였습니다.
  - 크롬 또는 익스플로어를 띄우신 후 localhost:8080/api/employee 하시면 확인이 가능합니다.

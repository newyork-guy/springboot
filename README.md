# report
NXP/CLO-SET Backend Dev 과제

# 구성요소
- Java 17 SDK (https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- Springboot 2.7.6
- json-simple 1.1.1
- opencsv 4.6
- jackson 2.11.3
- lombok
- h2 database

# 실행방법

1. h2 DB를 설치를 합니다.
  - 다운로드: http://www.h2database.com/html/download.html
  - 데이터베이스 -> "jdbc:h2:tcp://localhost/~/clo" 를 생성합니다.
![image](https://user-images.githubusercontent.com/52402303/208550048-e6ecc744-6659-47c7-b777-4632450e6b64.png)
![image](https://user-images.githubusercontent.com/52402303/208554734-6d85600d-cf1d-4f88-b3bd-0efc302614bd.png)


2. jar 파일을 실행 합니다.
  - Root 폴더로 이동 후 report.jar 파일을 아래와 같이 실행 합니다.
  - "java -jar report-0.0.1-SNAPSHOT.jar"

3. 포트는 8080으로 셋팅하였습니다.
  - 크롬 또는 익스플로어를 띄우신 후 localhost:8080/api/employee 하시면 확인이 가능합니다.

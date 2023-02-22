# architecture


1. 브라우저의가 요청한다
2. Controller가 요청을 받는다
3. Controller는 로직을 Service에게 전달 -> Spring MVC, Spring Core
4. Service는 DAO(Data Acess Object)에게 넘긴다 -> Spring JDBC
5. DB를 읽어온다 -> MySQL
6. DAO에서 읽어들인 값이 Service에게 전달된다
7. Service에게 전달된 값은 Controller에게 전달
8. Controller는 템플릿을 통해 화면에 출력
9. browser에 응답한다

# DTO
- 각 Controller, Service, DAO등을 layer라고 부르는데 layer간의 데이터 전송은 DTO(Data Transfer Object)를 통해 이루어진다

## 게시판 만드는 순서
1. Controller와 템플릿 생성
2. Service - 비지니스 로직을 처리(하나의 트랜잭션 단위로 처리)
3. Service는 비지니스 로직을 처리하기 위해 데이터를 CRUD 하기위해 DAO를 사용


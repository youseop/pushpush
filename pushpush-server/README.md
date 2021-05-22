# pushpush
Junction X Seoul - 전운보초

** 기능 구현 목록
[] 


[랜덤 입장]

1. (get) api/game/room-number

request 인자 없음 response {success:(boolean) room-number: (int)}



2. 방번호 정보 얻은 후에 아래 url로 게임  대기실 입장

url:  /waiting-room/${room-number}



3. 대기실 입장했으면 해당 번호로 소켓 연결
   - 게임 시작 관련한 소켓  -> 게임 시작 신호가 오면 모두 게임 방으로 이동시킨다.(인원수가 일정 이상이거나 방장역할의 사람이 플레이 버튼을 누르는 트리거가 필요할듯)
   - 채팅 관련한 소켓 -> 채팅 주고받는 용도



4. 게임 시작하면
   - 게임 시작 관련한 소켓은 off
   - 게임 도중 각 유저들의 좌표 정보 주고받을 소켓 연결
   - 채팅 관련한 소켓은 유지



5. 게임이 종료되면(대기실로 redirect)
   - 게임 도중 각 유저들의 좌표 정보 주고받는 소켓 off
   - 채팅 관련 소켓 유지
   - 게임 시작 관련 소켓 on



6. 대기실에서 나오면
   - 게임 시작 관련 소켓 off
   - 채팅 소켓 off



[프라이빗룸 생성]

1. (post)  api/game/private/room-number

request 인자 없음 response {success:(boolean) room-number: (int)}



2. 방번호 정보 얻은 후에 아래 url로 게임  대기실 입장

url:  /private-room/${room-number}




##Tomcat Server Setting
#
##JSP, HTML ModelAndView Path Setting
#spring.mvc.view.prefix=/WEB-INF/jsp/
#spring.mvc.view.suffix=.jsp
#
##JSP to Modify Not Restart Server
#server.servlet.jsp.init-parameters.development=true
#
#server.port=8080
#spring.datasource.url=jdbc:mysql://serverdb.cdo8uqshoxjn.ap-northeast-2.rds.amazonaws.com:3306/DB
#spring.datasource.username=admin
#spring.datasource.password=wjsdnsqhch0522
#
#
#spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
#spring.datasource.initialization-mode=ALWAYS
#spring.jpa.hibernate.ddl-auto=update
#
#spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
#
##Api Context Path prefix
#server.servlet.contextPath=/api



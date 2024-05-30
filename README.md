# order-management-service

📄 **github**

https://github.com/giwon512/order-management-service

# 🖊️프로젝트를 시작하게 된 계기

대학 중앙 동아리에서 임원진을 하고 있는 상황에서, 대학교 축제를 맞이하여 동아리 주점 부스를 열 계획을 세우게 되었다. 주문도 엄청 들어오는 데다가 주문 받는 사람도 여러 명이라 주문을 받아 관리하는 서비스가 없이는 주점 운영을 할 수가 없다. 축제 3일 간 가볍게 쓸 서비스를 찾을 수 없었고, 동아리 연합회에 주문 관리 서비스를 제공하겠다는 업체가 연락을 해왔지만, 수익금의 7% 내외를 수수료로 내야했기에, 이참에 직접 개발을 해보자고 생각하게 되었다.

# 🖊️프로젝트 목표

주문 관리 서비스이기 때문에, 구현 목표는 확실하다.

1. 손님들이 보는 주문 페이지는 시중의 다른 배달 어플과 비슷하게 구현(메뉴 목록, 장바구니, 주문 확인 페이지)
2. 주문 받은 내용을 확인할 수 있는 관리자 페이지 구현(현재 진행 중인 주문 내역, 총 주문 내역 페이지)
3. 외부 DB 설계 및 연결 후, 외부 서버에 최종 배포(클라우드 타입 활용)

# 📚 활용된 개발 언어 및 환경

![springboot.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/67bf9e45-f266-46b8-9cde-cade1e31b6ab/4c8f3b51-1864-4f17-98bb-a034e5972cc2/springboot.png)

![java.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/67bf9e45-f266-46b8-9cde-cade1e31b6ab/ec0718d5-148e-4765-b0a6-8fc57e6b6863/java.png)

![mybatis.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/67bf9e45-f266-46b8-9cde-cade1e31b6ab/d2ec9dc0-60e2-4e9d-8e0f-4fb13f5fda46/mybatis.png)

![thymeleaf-logo.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/67bf9e45-f266-46b8-9cde-cade1e31b6ab/64d31687-4101-45e2-a8d8-190f22e9e6ce/thymeleaf-logo.png)

![lombok.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/67bf9e45-f266-46b8-9cde-cade1e31b6ab/550e905e-139d-4980-8eee-056e5d8cf24c/lombok.png)

![tomcat.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/67bf9e45-f266-46b8-9cde-cade1e31b6ab/3d8d0f49-7785-4ed8-b46c-18c0662e8636/tomcat.png)

![mariadb.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/67bf9e45-f266-46b8-9cde-cade1e31b6ab/d874938a-b750-4612-ad60-f3caa8206f8c/mariadb.png)

![htmlCssJs.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/67bf9e45-f266-46b8-9cde-cade1e31b6ab/6e16b2b9-c8c2-45a5-9b0f-b9ac0f688cb2/htmlCssJs.png)

![heidisql.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/67bf9e45-f266-46b8-9cde-cade1e31b6ab/c7ffccaa-b8a2-4be6-bc0f-77951b3ca07b/heidisql.png)

![sts4.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/67bf9e45-f266-46b8-9cde-cade1e31b6ab/feb9772e-94bf-4391-8885-5f26dc7b9f94/sts4.png)

![cloudtype.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/67bf9e45-f266-46b8-9cde-cade1e31b6ab/164ddbbc-4e9c-4b33-b3f6-a54c86adb346/cloudtype.png)

![postman.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/67bf9e45-f266-46b8-9cde-cade1e31b6ab/e984ab04-3a77-4792-b2c6-0eff2cb2058f/postman.png)

# 🗂️ 서비스 사이트맵 구조

![sitediagram.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/67bf9e45-f266-46b8-9cde-cade1e31b6ab/d992f2d4-4643-41a5-9ca3-70ec2f71a8ee/sitediagram.png)

# 🗂️ 프로젝트 아키텍처

![architecture.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/67bf9e45-f266-46b8-9cde-cade1e31b6ab/f8922f6d-6759-4dd0-b3f6-8dbc096fa2f5/architecture.png)

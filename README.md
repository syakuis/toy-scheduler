# Scheduler - Toy Project

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=syakuis_toy-scheduler&metric=alert_status)](https://sonarcloud.io/dashboard?id=syakuis_toy-scheduler)

서버와 클라이언트가 실시간으로 데이터를 상호작용할 수 있도록 구현한다.

### 개발언어

- Spring boot
- Quartz Scheduler
- Ehcache
- Nashorn
- Reactjs
- Mobx
- axios
- Socket.io

### Todo

- [x] Scheduler 테스트 구현
- [x] 간단한 코멘트 작성 페이지 개발 - 서버
- [ ] 간단한 코멘트 작성 페이지 개발 - 클라이언트
- [ ] 상호작용을 위한 데이터 쌓기
- [ ] Nashorn 을 통한 서버 사이드 랜더링 구현

## 상호작용을 위한 데이터 쌓기

과거 작업이 실행될 필요가 없으므로 DB 에 저장하는 것보다 캐시(Ehcache) 를 이용하는 것이 좋을 것 같음.

~~트리거로 테이블 이벤트를 쌓고 Scheduler 가 이를 주기적으로 조회하여 결과를 클라이언트에게 넘겨주고 관련된 이벤트가 실행된다.~~

- [ ] 특정 작업이 실행되면 Ehcache 에 기록한다.
- ~~이벤트 트리거 API 개발  (특정 작업시 이벤트 트리거에 데이터를 저장함) - 선언적으로 개발~~ 캐시사용으로 필요없음
- [ ] Scheduler 가 주기적으로 Ehcache 조회하여 조회된 이벤트를 Socket 통신으로 프론트에 전달한다.
- [ ] 프론트는 전달 받은 이벤트의 작업을 실행한다.
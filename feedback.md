1. 검증
   1. PersonName
      1. "," 검증메서드를 사용해야할까?
   2. Height
      1. validatePositiveNumber 메서드 쪼개는게 좋을 것 같음
   3. LadderGameController
      1. printSadari 메서드 이름 변경
      2. line의 List<Boolean> 반환하는거 별로인 듯
      3. Height 왜 노출되어야하는지 모르곘음
      4. 뷰로직은 뷰가 가져갔으면 좋겠다.

2. 한글주석 어떤 것 같아

3. 객체
   1. Line
      1. if - else 지양하자
      2. if문 조건 해석안돼
      3. 랜덤생성기 인터페이스 지향해라

4. 테스트
   1. 메서드명과 DisplayName 동일한거에 대한 고민해보기
   2. Junit을 사용했는데, 왜 Assertions 썻어?

5. 다형성
   1. PersonName
      1. 속성값에 인터페이스 씁시다.


--- 2차 피드백

1. DTO
   1. 왜 쓸까?
   2. Mapper는 MVC중 누구꺼일까?

2. 의존성
   1. 람다와 익명클래스 공부해보기
   2. 컨트롤러 의존성 줄이기

3. getter
   1. 왜 지양하라는 걸까?

4. 테스트
   1. 테스트 커버리지가 너무 낮다.


--- 3차 피드백
1. 객체 의존도 그려볼 것

2. 컨벤션
   1. (다음미션부터) 필드 두개 이상 갖지 말 것

3. 네이밍
   1. LadderGame의 필드 중 map이 cached라는 이름을 가지는게 맞을까?

4. 책임
   1. inputView
      1. 파싱하면 안될까?
      2. (,)에 대한 검증은 inputView에 대한 책임일까?

5. 방어적 복사
   1. getter를 통해 값을 반환할 떄 방어적 복사에 대해서 신경쓰자.

6. 의존성 주입
   1. LineGenerator는 라인을 만드는 객체만 알면 되지 않을까? LadderGameController가 알아야할까?

7. 테스트
   1. 테스트는 어디까지 생각하고 짜야할까?
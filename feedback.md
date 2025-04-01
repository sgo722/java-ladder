1. 검증
   1. PersonName
      1. "," 검증메서드를 사용해야할까?
   2. Height
      1. validatePositiveNumber 메서드 쪼개는게 좋을 것 같음
   3. LadderGameController
      1. printSadari 메서드 이름 변경
      2. line의 List<Boolean> 반환하는거 별로인 듯
      3. Height왜 노출되어야하는지 모르곘음
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

1. 검증
   1. PersonName
      1) "," 검증메서드를 사용해야할까?
         A) ","가 포함되어있는지 검증하는 메서드는 테스트를 위한 프로덕션 코드가 된 것 같습니다.
   2. Height
      1) validatePositiveNumber 메서드 쪼개는게 좋을 것 같음
         A) 두가지 매서드로 분리했습니다.
            validateNumber - 숫자만 검증 
            validatePositive - 양수인지 검증
   3. LadderGameController
      1. printSadari 메서드 이름 변경 -
         A) 메서드 이름을 print로 변경하고, 2가지 출력기능을 포함시켰습니다. 각각의 사다리 주인과 사다리 모양을 출력합니다.
      2. line의 List<Boolean> 반환하는거 별로인 듯
         A)
      3. Height 왜 노출되어야하는지 모르곘음
         A)
      4. 뷰로직은 뷰가 가져갔으면 좋겠다.
         A)

2. 한글 주석
   1. 한글주석은 가독성을 향상시킬 수 있지만, 수정지점을 늘어날 수 있다는 현실적인 단점이 있습니다.

3. 객체
   1. Line
      1. if - else 지양하자
         A) if-else문을 if문 두개로 나누어 처리
      2. if문 조건 해석안돼
         A) 지역변수를 활용해 로직이해를 조금 더 쉽게 만들었습니다.
      3. 랜덤생성기 인터페이스 지향해라
         A) 

4. 테스트
   1. 메서드명과 DisplayName 동일한거에 대한 고민해보기
      A) 
   2. Junit을 사용했는데, 왜 Assertions 썻어?
      A) 

5. 다형성
   1. PersonName
      1. 속성값에 인터페이스 씁시다.
         A)
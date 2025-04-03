
1. 검증
   1. PersonName
      1) "," 검증메서드를 사용해야할까?  
         A1) ","가 포함되어있는지 검증하는 메서드는 테스트를 위한 프로덕션 코드가 된 것 같습니다.
   2. Height
      1) validatePositiveNumber 메서드 쪼개는게 좋을 것 같음  
         A1) 두가지 매서드로 분리했습니다.
            validateNumber - 숫자만 검증 
            validatePositive - 양수인지 검증
   3. LadderGameController
      1. printSadari 메서드 이름 변경  
         A1) 메서드 이름을 print로 변경하고, 2가지 출력기능을 포함시켰습니다. 각각의 사다리 주인과 사다리 모양을 출력합니다.
      2. line의 List<Boolean> 반환하는거 별로인 듯
         A1)
      3. Height 왜 노출되어야하는지 모르곘음  
         A1) Height 객체가 최대 높이를 Lines에게 주입해주지 않으면, Lines를 못만든다 => 최대 높이를 모르니까
                처음에는 Lines의 개수가 높이자나라는 말을 듣고 Height를 숨기려고했지만, 생각해보니 높이가 주입되었기 떄문에 Lines를 만들 수 있었던 것이다.  
         A2) Height와 PersonName을 포함하는 GameCondition을 만들고 주입하는 방식을 생각해봤는데, 이 방식은 GameCondtion과 Lines가 서로 관계를 맺게된다.
                현재방식은 Height, PersonName, Lines가 서로 모르는 상태인데, GameCondition과 Lines가 서로 의존성이 생기는것에 대한 거부감이 있다.  
      4. 뷰로직은 뷰가 가져갔으면 좋겠다.  
         A1) 

2. 한글 주석
   1. 한글주석은 가독성을 향상시킬 수 있지만, 수정지점을 늘어날 수 있다는 현실적인 단점이 있습니다.

3. 객체
   1. Line
      1. if - else 지양하자  
         A) if-else문을 if문 두개로 나누어 처리
      2. if문 조건 해석안돼  
         A) 지역변수를 활용해 로직이해를 조금 더 쉽게 만들었습니다.
      3. 랜덤생성기 인터페이스 지향해라  
         A1) LineGenerator 인터페이스를 만들고, RandomNumberGenerator를 구현체로 변경  
         A2) LineGenerator 인터페이스가 가지는 메서드 명에 대해서 고민하게됌. generate와 tryGenerate 두개를 고민했고, 반환하는 값이 false일 수도 있으니 tryGenerate를 적용했습니다.
      4. for문 지역변수 i 쓰지말 것  
         A1) makePoints의 반복문의 지역변수 i는 다리를 설치할 수 있는 포인트를 의미한다. connectionIndex, bridgeIndex, position을 고민해보다가 bridgeIndex가 와닿아서 적용했습니다.

4. 테스트
   1. 메서드명과 DisplayName 동일한거에 대한 고민해보기  
      A) 
   2. Junit과 Assertions의 차이에 대해 고민해보기
      A) 

5. 다형성
   1. PersonName
      1. 속성값에 인터페이스 씁시다.  
         A) ArrayList -> List로 변경했습니다.
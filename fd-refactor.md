
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
      A1) @DisplayNameGeneration을 통해 언더바를 공백으로 바꿀 수 있는 애노테이션에 대해서 학습했습니다. @DisplayName은 테스트결과에 출력되는 메서드이름을 대체합니다.  
         메서드명과 DisplayName이 동일하게 쓸 거면 왜 쓰지? 
      A2) 동일하게 사용하더라도 @DisplayName를 통해 가독성을 향상시킬 수 있을거라고 생각했습니다. 한편으로는 코드를 더럽히는 행동처럼 보일 수 있을 것 같습니다.
          유닛 테스트 네이밍 7가지 중 하나를 정해야한다면 기능을 적는 것을 사용할 것 같습니다.   
          대부분 메서드명은 영어로 @DisplayName은 한글로 해놓은 경우가 많았습니다. 둘다 한글로 하지 않은 이유는 뭘까?  
      A3) 구성원들이 한국인이라면 괜찮을 수 있다. 그렇지만 우리가 사용하는 도구들이 영어기반이라 한글로 작성했을 시 문제가 발생할 수 있다고하여 영어로 작성하기로 결정했습니다.
   2. Junit과 Assertions의 차이에 대해 고민해보기
      A1) Junit보다는 Assertions를 사용하려고 합니다.
         Assertions가 더 풍부하게 지원한다는 사실에 대해서 알았습니다. 메소드 체이닝, 자동완성(?), 콜렉션테스트, 예외메시지 테스트, 표현력에서의 차이가 있다는 사실을 알 수 있었습니다.
         자동완성에 차이가 있다는게 무슨말일까?  
      A2) static import를 사용함으로써 Assertions 클래스명 없이도 사용할 수 있다는 점을 말하는 것 같다. 이를 사용함으로써 가독성이 향상된다고 생각하는 것 같다. 그러면 static import를 사용하는 것은 괜찮은 걸까?
      A3) static import는 정적 변수나 정적 메서드를 클래스 없이도 사용할 수 있습니다. 테스트 코드에서 Assertions를 사용하기 위한 static import는 의도가 명확하기에 사용하는 편인듯 싶다.  
          프로덕션 코드에서는 오류지점이 될 수 있고, 맥락파악을 해야하므로 쓰지 않는 것이 좋겠다.

5. 다형성
   1. PersonName
      1. 속성값에 인터페이스 씁시다.  
         A) ArrayList -> List로 변경했습니다.

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
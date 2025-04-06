# 기능 요구 사항
1. 사다리 게임에 참여할 인원을 입력받는다.
2. 사다리 최대 높이를 입력받는다.
3. 사다리를 생성한다.
4. 사다리를 출력한다.

---
# 기능 분석
1. 사다리 게임을 참여할 인원을 입력받는다.
   1. 입력된 값을 검증한다.
   2. 쉼표(,)로 구분된 인원을 분리한다.

2. 사다리 최대 높이를 입력받는다.
   1. 숫자인지 검증한다.
   2. 숫자로 변환한다.

3. 사다리를 생성한다.
   1. 최대 높이에 해당 하는 사다리를 생성한다.

4. 사다리를 출력한다.

# 첫 번쨰 구조
              LadderGameController(사다리 게임 제어)
                          /      \
                  PersonName(사람)  Lines(사다리 일급컬렉션)
                                    |
                                 Line(사다리 실행한다)


# 고민
1. 객체 생성
   Person/Name 둘중 뭐를 만들 것인가?
   1. Person,Name 이 구조를 가져가면 자동차 경주에서 처럼 깊은 의존성이 생길 것 같다.
   2. Name이 구조만 가져가면 의존성의 깊이가 생기는 것은 피할 수 있으나 의미가 헷갈리지 않을까?
   3. 카 - 카이름 / 사다리-사람이름 => 동일한 관계는 아닌 것 같아서 고민된다. 의존성 깊은 것은 피하고싶은데 어떻게 할 수 있을까
      지금은 의존성 깊은 것을 피하고 싶고, 의미의 모호성을 피하기 위해서 PersonName을 사용하게 되었다.


2. getter를 지양하라
   3. 정적 팩터리 메서드를 사용하면 게터를 지양할 수 있을 것 같은데,

3. 클린코드
   1. 상수 위치
      1. PersonName에 상수가 들어가는데 상수를 가장 위에 올리는게 맞나?



--- 1차 피드백 이후
1. 로직 분리
   2. Line[해결]
      1. 다리 생성 로직을 어떻게 더 이쁘게 만들 수 있을까?
         1. 검사 - 생성 방식 [메서드 분리로 해결]
         2. 생성 - 검증 -> 재생성 or 반환 [적용 X]
            - 근데 validateBridge이런 메서드가 Line책임인가라고 생각했을때 아닌 것 같다.
            - validateLine은 어떤가? 이러면 Line책임이 맞는 것 같긴한데...
         3. Bridge라는 enum 타입을 만든다면 이를 어떻게 활용할 수 있을까?
         4. Line이 Bridges(Bridge 일급 컬렉션)을 가지는 건 어떨까?
            - 의존성이 좀 깊어지는 것 같다.
               - Lines - Line - Bridges - Bridge ? Line과 Bridges가 뭐가 다른가? 쓸떼없이 의존성을 늘리는 느낌이다.
                  - Line : List<Bridge> bridges;
                  - Bridges : List<Bridge> bridges;
         5. LineGenerator가 라인 생성 책임을 가져간다. [적용 O]
            1. LineGenerator가 Line생성에 대한 책임을 가져가고, Line은 생성할 떄 검증을, LineGenerator는 생성하는 역할을 한다. Line과 LineGenerator의 의존성을 분리했다.
            2. LineGenerator의 이름만보면 Line을 반환해야하는데, Line 객체의 필드값으로 있으니 어떻게 저장하지 고민하다 외부로부터 생성해야겠다는 생각이 들었다.

2. DTO
   1. View만의 로직 분리
      2. View만의 로직을 설계하기 위해선 DTO가 필요하다 생각되었다.
         1. DTO로 변환하는 로직은 누가 가지고 있어야하는가?
            2. Lines와 Line에 변환하는 로직을 작성했다. DTO에 의존성이 생긴건 거부감이 없는가?
               1. 도메인이 DTO를 알고있는 것은 좋지않다. 왜냐하면 둘의 생명주기가 다르다. 도메인은 비즈니스에 종속되어있고, DTO는 뷰에 종속되어있기에 둘의 생명주기가 다르기에 분리하는게 둘의 의존성을 끊어내는 것이 맞다고 생각한다.
                  1. [Mapper 도입] 도메인안에 toDto메서드가 있던 상태에서 Mapper를 사용해서 의존성을 끊어냈다.
                     1. LineMapper가 Line까지 알고있고, Line의 메서드를 호출하는 상태 이거 괜찮은가?
                        1. [모르겠음]
                     2. PersonNameMapper가 PersonName의 메서드를 호출하는 이 상태 괜찮은가?
                        1. [모르겠음 == 위의 내용과 동일]
   2. getter 지양
      1. DTO를 쓰려고 모델에 toDto라는 메서드를 사용하게되면서 도메인 단에서 getter메서드의 사용이 없어지고 있다는 느낌을 받았다.
      2. 도메인단에서 사용하지 않았지만 뷰단에서 결국 getter를 값을 가져와 출력하고 있는데 이는 괜찮은가?
         1. [애매하다] 뷰는 DTO로부터 getter를 사용하는 것이므로 괜찮다?
   3. DTO를 감싼 DTO는 어떤지?
      1. PersonNameDtos - ArrayList<PersonNameDto>
         1. DTO가 반환될거라고 생각했는데 List<DTO>가 반환되면 좀 이상하다고 생각할 수 있을 것 같긴하다.  
            계속 감싸면 너무 깊이 만들어질수도 있을것 같다. 깊이 만들어지면 안되나? 공부해야겠다.
            1. [애매하다] DTO안에 DTO를 쓰면 어떻게 될까?
               - 컬렉션이 코드로 드러나지 않는다 -> 코드는 깔끔해지겠지만 가독성이 올라가나? 이거 장점인가?
               - 클래스가 많아진다 -> 단점
               - 지금으로선 장점은 애매하고 단점은 확실하니 안쓰는 쪽으로 해야할 것 같다.  
                 DTO안에 DTO상태를 외부 DTO안 내부 DTO가 존재한다고 표현해보자.
                 현재는 외부DTO에 컬렉션형태의 내부DTO만 들어가기때문에 사용하지 않는 쪽이 좋다고 생각한다.
                 만약 추가적인 정보가 포함되어야한다면 고려해볼 것 같다.
   4. DTO는 언제써야할까?
      1. DTO를 쓰기로 마음먹었다면 List<String>으로 넘어왔던 것들도 List<DTO>로 모두 변환해야하나? 공부해야겠다.
         1. [애매하다] 모두 변환해야 일관성있는 코드로 생각하고 뷰에서 찍어낼떄 좋지 않을까?

3. 객체분리
   1. Height
      1. Height는 VO다. 이 값을 Height 필드인 height 값을 컨트롤러에 노출시키지 않고 어떻게 Lines에 넘겨줌으로써 Lines들을 생성할 수 있을까?
         1. Height 객체를 생성자 파라미터로 넣는다?
            1. Lines와 Height의 의존성이 생기는건 괜찮은가?
               1. [해결] 2안으로 해결해서 Lines는 Height에 대해 전혀 모른다.
      2. 메서드를 추가하여 의존성이 생기지 않도록 해결함
         1. Height 객체의 높이를 확인하면서 canInstall과 install 메서드를 추가하여 모두 다 설치되었는지 확인하도록 처리해서 의존성 문제를 끊어냈다.
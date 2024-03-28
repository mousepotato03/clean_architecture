# Clean Architecture 

* Android Jetpack Compose
* MVVM
* Coroutine(Flow)

## 예제
> Product 리스트를 로드해서 화면에 출력하기

> 새로운 Product를 추가하기

> 마지막 Product를 삭제하기


## 패키지 세팅
각 계층 단위로 구성
* Presentation Layer: ComposeView, ViewModel

* Domain Layer: UseCase, RepositoryInterface, DomainModel

* Data Layer: RepositoryImpl, DataSource, DataModel

## 결과
* View, ViewModel, UseCase, Repository, DataSource, Mapper로 구성된 아키텍쳐

* View는 ViewModel의 상태를 구독하고, 함수를 호출

* ViewModel은 View를 모르고, UseCase를 통해 데이터 접근 수정

* UsecCase는 ViewModel을 모르고, Repository를 통해서 데이터 접근 및 수정

* Repository는 UseCase를 모르고, DataSource를 통해 데이터 접근 수정

* DataSource는 Repository를 모르고, 내부적으로 상태와 함수를 구현.

각 컴포넌트 별로 각자의 역할에 집중해서 로직을 응집하고, 의존성을 최소화 함.

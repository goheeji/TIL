# 다운 캐스팅과 instanceof

## 하위 클래스로 형 변환, 다운캐스팅
묵시적으로 상위 클래스 형 변환된 인스턴스가 원래 자료현(하위클래스)으로 변환되어야 할 때 다운캐스팅이라 함

하위 클래스로의 형 변환은 명시적으로 되어야 함

Customer vc = new VIPCustomer(); //묵시적
VIPCustomer vCustomer = (VIPCustomer)vc; //명시적

instanceof를 사용해서 안정적으로 다운캐스팅을 할 수 있다.
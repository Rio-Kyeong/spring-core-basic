package hello.core.singleton;

public class SingletonService {

    // 1. static area에 객체 instance를 미리 하나 생성해서 올려둔다.
    // - 프로그램 실행 시 Class Loader는 static 키워드를 가진 모든 것들을 static Area에 메모리를 할당한다.
    // - 이미 생성된 객체 instance를 가져와서 사용하기 때문에 하나의 인스턴스만 생성된다.
    private static final SingletonService instance = new SingletonService();

    // 2. public으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회할 수 있다.
    public static SingletonService getInstance(){
        return instance;
    }

    // 3. 딱 1개의 객체 인스턴스만 존재해야 하므로, 생성자를 private으로 선언해서 외부에서 new 키워드를 통해 객체 생성을 못하게 막는다.
    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}

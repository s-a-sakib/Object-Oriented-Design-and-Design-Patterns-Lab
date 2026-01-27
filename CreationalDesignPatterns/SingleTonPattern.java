//  https://www.tutorialspoint.com/design_pattern/singleton_pattern.htm

class SingleTon{
      private static final SingleTon instance = new SingleTon();
      private SingleTon(){
      }
      public static SingleTon getInstance(){
            return instance;
      }
      
      public void showMessage(String message){
            System.out.println("Client Message: " + message);
      }
}

public class SingleTonPattern{
    public static void main(String[] args){
          SingleTon object1 = SingleTon.getInstance();
          SingleTon object2 = SingleTon.getInstance();
          
          if(object1 == object2){
              System.out.println("Both are same instance");
          }else{
              System.out.println("Not same instance");
          }
          
          object1.showMessage("Hi, I am Sakib.");
          object2.showMessage("Hi, I study in University of Rajshahi.");
    }
}

// Factory Design Pattern Example in Java
// From turorial point: https://www.tutorialspoint.com/design_pattern/factory_pattern.htm


//package ObjectOrientedDesignLab.CreationalDesignPatterns;

// Step 1: Create an interface
interface Shape {
    void draw();
}

class Circle implements Shape{
    @Override
    public void draw(){
        System.out.println("This is Circle");
    }
}

class Square implements Shape{
    @Override
    public void draw(){
        System.out.println("This is Square");
    }
}

class Rectangle implements Shape{
    @Override
    public void draw(){
        System.out.println("This is Rectangle");
    }
}

class ShapeFactory{
    public Shape getShape(String shapeType){
        if(shapeType == null){
              return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
         
        }else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
         
        }else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
      }
  }
  
  public class FactoryPattern{
      public static void main(String[] args){
          ShapeFactory shapeFactory = new ShapeFactory();
          
          Shape shape1 = shapeFactory.getShape("CIRCLE");
          shape1.draw();
          
          Shape shape2 = shapeFactory.getShape("RECTANGLE");
          shape2.draw();
          
          Shape shape3 = shapeFactory.getShape("SQUARE");
          shape3.draw();
      }
  }
  
  
  /*
    cd CreationalDesignPattens
    javac FactoryPattern.java
    java FactoryPattern
  */

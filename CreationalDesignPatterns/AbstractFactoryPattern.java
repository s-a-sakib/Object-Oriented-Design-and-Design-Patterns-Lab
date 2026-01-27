// Abstruct Factory Design Pattern Example in Java
// From turorial point: https://www.tutorialspoint.com/design_pattern/abstract_factory_pattern.htm

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

class RoundedSquare implements Shape{
    @Override
    public void draw(){
        System.out.println("This is Rounded Square");
    }
}

class RoundedRectangle implements Shape{
    @Override
    public void draw(){
        System.out.println("This is Rounded Rectangle");
    }
}

abstract class AbstractFactory{
    abstract Shape getShape(String shapeType);
}

class ShapeFactory extends AbstractFactory{
    @Override
    public Shape getShape(String shapeType){
    
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

class RoundedShapeFactory extends AbstractFactory{
    @Override
    public Shape getShape(String shapeType){
          if(shapeType.equalsIgnoreCase("RECTANGLE")){
                return new RoundedRectangle();
          }else if(shapeType.equalsIgnoreCase("SQUARE")){
                return new RoundedSquare();
          } 
          return null;
    }
}

class FactoryProducer{
    public static AbstractFactory getFactory(boolean rounded){
        if(rounded){
            return new RoundedShapeFactory();
        }else{
            return new ShapeFactory();
        }
    }
}

public class AbstractFactoryPattern {
   public static void main(String[] args) {
      //get shape factory
      AbstractFactory shapeFactory = FactoryProducer.getFactory(false);
      //get an object of Shape Rectangle
      Shape shape1 = shapeFactory.getShape("RECTANGLE");
      //call draw method of Shape Rectangle
      shape1.draw();
      //get an object of Shape Square 
      Shape shape2 = shapeFactory.getShape("SQUARE");
      //call draw method of Shape Square
      shape2.draw();
      //get shape factory
      AbstractFactory shapeFactory1 = FactoryProducer.getFactory(true);
      //get an object of Shape Rectangle
      Shape shape3 = shapeFactory1.getShape("RECTANGLE");
      //call draw method of Shape Rectangle
      shape3.draw();
      //get an object of Shape Square 
      Shape shape4 = shapeFactory1.getShape("SQUARE");
      //call draw method of Shape Square
      shape4.draw();
   }
} 

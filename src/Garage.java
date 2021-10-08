import com.sun.xml.internal.ws.api.message.Message;


import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



public class Garage {

    private ArrayList<Car> carArrayList = new ArrayList<>();

    public ArrayList<Car> getCarArrayList() {
        return carArrayList;
    }

    public void setCarArrayList(ArrayList<Car> carArrayList) {
        this.carArrayList = carArrayList;
    }

    public Garage() {

    }

    // Добавление машины в Коллекцию
    public void addNewCar(Car car){

        carArrayList.add(car);
    }

    // Удаление машины из Коллекции по имени.
    public void deleteCar(String name){

        carArrayList.removeIf(car -> car.getName().equals(name));
    }

    // Выыод на экран отсотрированной по имени коллекции машин.
    public void printCarsSortedByName(){
       carArrayList.stream().sorted(new Comparator<Car>() {
           @Override
           public int compare(Car a, Car b) {
               return a.getName().toUpperCase().compareTo(b.getName().toUpperCase());
           }
       }).forEach(car -> System.out.println(car.getClass()+" - "+ car.getName()));
    }
    // Вывод на экран машин из коллекции по заданному типу топлива
    public void printCarsSortedByFuelType(Car.FuelType type){
        carArrayList.stream().filter(x -> x.getType().equals(type))
                             .forEach(s -> System.out.println(s.toString()));
    }
    // Найти количество машин заданного цвета
    public int getNumberOfCars(String color){

        return (int) carArrayList.stream().filter(x -> x.getColor().equals(color)).count();
    }
   // Сохранить коллекцию машин в текстовый файл.
    public void saveTotxtFile(String fileName, ArrayList<Car> list){
        StringBuilder builder = new StringBuilder();
        for (Car car: list) {
            builder.append(car.toString());
        }
        try {
            Files.write(Paths.get(fileName), Collections.singleton(builder), Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Cохранить коллекцию машин в JSON/XML файл.
/*    public void  saveToJSonFile(Garage garage){
        XStream xstream = new XStream();
        xstream.setMode(XStream.NO_REFERENCES);
        xstream.alias("garage", Garage.class);
        System.out.println(xstream.toXML(garage));
        try{
            FileOutputStream fs = new FileOutputStream("C:/Users/IdeaProjects/Lesson17/employeedata.txt");
         xstream.toXML(garage, fs)
           } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
   }*/

    public static void main(String[] args){

        Garage garage = new Garage();

        garage.carArrayList.add( new Bus("green", "Mersedes", Car.FuelType.Diesel, 4, 10));
        garage.carArrayList.add( new Bus("read", "volvo", Car.FuelType.Diesel,5, 22));
        garage.carArrayList.add (new PassengerCar( "yellow", "Ferrari", Car.FuelType.Gasoline, "leather"));
        garage. carArrayList.add(new PassengerCar("grey","Audi",Car.FuelType.Gasoline,"velur"));

        garage.printCarsSortedByFuelType(Car.FuelType.Diesel);
        System.out.println("-----------------");
        garage.addNewCar(new Bus("red", "Nissan",Car.FuelType.Diesel,6, 25));
        garage.printCarsSortedByFuelType(Car.FuelType.Diesel);
        System.out.println("-----------------");
        System.out.println(garage.getNumberOfCars("red"));
        System.out.println("-----------------");
        garage.printCarsSortedByName();
        System.out.println("-----------------");
        garage.deleteCar("volvo");
        garage.printCarsSortedByName();


        garage.saveTotxtFile("Garage.txt", garage.carArrayList );
     //   garage.saveToJSonFile(garage);
    }
}

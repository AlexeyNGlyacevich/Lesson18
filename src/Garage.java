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

    public ArrayList<Car> carArrayList = new ArrayList<>();


    public Garage() {
        carArrayList.add(new Bus(4, 10, "green", "Mersedes", Car.fuelType.Diesel));
        carArrayList.add (new Bus(5, 22, "read","volvo", Car.fuelType.Diesel));
        carArrayList.add (new PassengerCar("leather", "yellow", "Ferrari",Car.fuelType.Gasoline));
        carArrayList.add(new PassengerCar("velur","grey","Audi",Car.fuelType.Gasoline));
    }

    // Добавление машины в Коллекцию
    public void AddNewCarToArrayList(Car car){

        carArrayList.add(car);
    }

    // Удаление машины из Коллекции по имени.
    public void DeleteCar(String name){

        carArrayList.removeIf(car -> car._name.equals(name));
    }

    // Сортировка по Имени машины.
    public void GarageSortForName(){
       carArrayList.stream().sorted(new Comparator<Car>() {
           @Override
           public int compare(Car a, Car b) {
               return a.getName().toUpperCase().compareTo(b.getName().toUpperCase());
           }
       }).forEach(car -> System.out.println(car.getClass()+" - "+ car.getName()));
    }

    public void GetDieselCars(){
        carArrayList.stream().filter(x -> x._type.equals(Car.fuelType.Diesel))
                    .forEach(s -> System.out.println(s.toString()));
    }
    // Найти количество машин заданного цвета
    public int GetNumberOfCars(String color){

        return (int) carArrayList.stream().filter(x -> x._color.equals(color)).count();
    }
   // Сохранить коллекцию машин в текстовый файл.
    public void Savetofile(String fileName, ArrayList<Car> list){
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


    public static void main(String[] args){

        Garage garage = new Garage();
        garage.GetDieselCars();
        System.out.println("-----------------");
        garage.AddNewCarToArrayList(new Bus(6, 25,"red","Nissan", Car.fuelType.Diesel ));
        garage.GetDieselCars();
        System.out.println("-----------------");
        System.out.println(garage.GetNumberOfCars("red"));
        System.out.println("-----------------");
        garage.GarageSortForName();
        System.out.println("-----------------");
        garage.DeleteCar("volvo");
        garage.GarageSortForName();

        garage.Savetofile("Garage.txt", garage.carArrayList );
    }
}

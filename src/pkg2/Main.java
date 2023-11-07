package pkg2;

public class Main {

    public static void main(String[] args){

        Car car = new Car("Company_car", "Model_car", 2021);
        System.out.println(car.toString());

        Motorcycle moto = new Motorcycle("Company_moto", "Model_moto", 2022);
        System.out.println(car.toString());

    }

}
package streamApi;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class StreamRunner {
    public static void main(String[] args) {
        Optional<Integer> max = Dish.menu.stream()
                .map(Dish::getCalories)
                .max(Integer::compareTo);

        if (max.isPresent()) {
            max.get();
        }

        Integer i = max.orElse(0);
        System.out.println(i);

        Integer i1 = max.orElseThrow();
        System.out.println(i1);

        max.ifPresent(num -> System.out.println(num));
    }
}

//        class ShapeCalculator {
//            //который будет вычислять площадь и периметр фигуры.
//            public String calculate(String input) {
//                Scanner scanner = new Scanner(System.in);
//                String[] input = scanner.nextLine().split(" ");
//
//                String figureType = input[0];
//                double measurement = input.length > 1 ? Double.parseDouble(input[1]) : 1.0;
//
//                switch (figureType) {
//                    case "круг":
//                        calculateCircle(measurement);
//                        break;
//                    case "квадрат":
//                        calculateSquare(measurement);
//                        break;
//                    default:
//                        System.out.println("Неправильный тип фигуры!");
//                }
//            }
//
//            private static void calculateCircle(double radius) {
//                double area = Math.PI * radius * radius;
//                double perimeter = 2 * Math.PI * radius;
//                System.out.printf("%.2f %.2f\n", area, perimeter);
//            }
//
//            private static void calculateSquare(double side) {
//                double area = side * side;
//                double perimeter = 4 * side;
//                System.out.printf("%.2f %.2f\n", area, perimeter);
//            }
////                    input.split(" ");
////
////                    if (input.equals("круг")) {
////                        double pl = Math.PI * measurement * measurement;
////                        double per = 2 * Math.PI * measurement;
////
////                        return Math.PI * measurement * measurement;
////                    } else if (type.equals("квадрат")) {
////                        return measurement * measurement;
////                    } else {
////                        return 0.0;
////                    }
////
////                    if (type.equals("круг")) {
////                        return 2 * Math.PI * measurement;
////                    } else if (type.equals("квадрат")) {
////                        return 4 * measurement;
////                    } else {
////                        return 0.0;
////                    }
////                }
////                    // Ваш код
////                    return "0.00 0.00";
////                }
//        }
//    }
//}
